package cc.robotdreams;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating students objects
        Student rachel = new Student("Rachel", "Green");
        Student monica = new Student("Monica", "Geller");
        Student phoebe = new Student("Phoebe", "Buffay");
        Student joey = new Student("Joey", "Tribbiani");
        Student chandler = new Student("Chandler", "Bing");
        Student ross = new Student("Ross", "Geller");
        Student gunther = new Student("Gunther", "Smith");
        Student janice = new Student("Janice", "Fox");

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
        group.addAssignment(StudentsGroup.TO_STUDY_ENCAPSULATION);

        // Marking the task as performed for students
        group.markAssignmentAsDone(monica, StudentsGroup.TO_STUDY_ENCAPSULATION);
        group.markAssignmentAsDone(phoebe, StudentsGroup.TO_STUDY_ENCAPSULATION);
        group.markAssignmentAsDone(joey, StudentsGroup.TO_STUDY_ENCAPSULATION);
        group.markAssignmentAsDone(chandler, StudentsGroup.TO_STUDY_ENCAPSULATION);

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
        System.out.println("Group assignments:");
        for (String assignment : group.getAssignments()) {
            System.out.println("  " + assignment);

            // Display the students who received the "To Study Encapsulation" task
            System.out.println("Students who received the assignment \"" + assignment + "\":");
            List<Student> studentsWithEncapsulationAssignment = group.getStudentsWithAssignment(assignment);
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
