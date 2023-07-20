package cc.robotdreams;

import  java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Creating students objects
        Student rachel = new Student(1, "Rachel", "Green");
        Student monica = new Student(2, "Monica", "Geller");
        Student phoebe = new Student(3, "Phoebe", "Buffay");
        Student joey = new Student(4, "Joey", "Tribbiani");
        Student chandler = new Student(5, "Chandler", "Bing");
        Student ross = new Student(6, "Ross", "Geller");
        Student gunther = new Student(7, "Gunther", "Smith");
        Student janice = new Student(8, "Janice", "Fox");

        // Creating the group object with headman Rachel Green
        StudentsGroup group = new StudentsGroup(rachel);

        // Adding all students to the group
        group.addStudent(rachel);
        group.addStudent(monica);
        group.addStudent(phoebe);
        group.addStudent(joey);
        group.addStudent(chandler);
        group.addStudent(ross);
        group.addStudent(gunther);
        group.addStudent(janice);

        // Headman changing to Monica Geller
        group.setHead(monica);

        // Adding a task for the whole group
        group.addAssignment("To study encapsulation");

        // Marking the task as performed for students
        group.markAssignmentAsDone(monica, "To study encapsulation");
        group.markAssignmentAsDone(phoebe, "To study encapsulation");
        group.markAssignmentAsDone(joey, "To study encapsulation");
        group.markAssignmentAsDone(chandler, "To study encapsulation");

        // Adding the "First Task" task for Monica Geller and Phoebe Buffay
        group.getCompletedAssignments(monica).add("First task");
        group.getCompletedAssignments(phoebe).add("First task");

        // Output students' list as an array in a console
        System.out.println("Students list:");
        for (Student student : group.getStudents()) {
            System.out.println(student.getId() + " " + student.getFirstName() + " " + student.getLastName());
        }

        System.out.println("Group head: " + group.getHead());

        // List of students who received the task
        List<Student> studentsToDisplayAssignments = new ArrayList<>();
        studentsToDisplayAssignments.add(monica);
        studentsToDisplayAssignments.add(phoebe);
        studentsToDisplayAssignments.add(joey);
        studentsToDisplayAssignments.add(chandler);

        // Show the task for this group and task that was completed for selected students
        System.out.println("Group assignments:");
        for (String assignment : group.getAssignments()) {
            System.out.println("  " + assignment);

            // Display the students who received the "To Study Encapsulation" task
            System.out.println("Students who received the assignment \"To study encapsulation\":");
            List<Student> studentsWithEncapsulationAssignment = group.getStudentsWithAssignment("To study encapsulation");
            for (Student student : studentsWithEncapsulationAssignment) {
                System.out.println("  " + student.getFirstName());
            }

        }
        System.out.println("Completed assignments by Monica Geller:");
        for (String assignment : group.getCompletedAssignments(monica)) {
            System.out.println("  " + assignment);
        }
        System.out.println("Completed assignments by Phoebe Buffay:");
        for (String assignment : group.getCompletedAssignments(phoebe)) {
            System.out.println("  " + assignment);
        }
    }
}
