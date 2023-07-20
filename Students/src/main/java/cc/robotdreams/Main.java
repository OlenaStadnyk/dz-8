package cc.robotdreams;

import  java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів студентів
        Student rachel = new Student(1, "Rachel", "Green");
        Student monica = new Student(2, "Monica", "Geller");
        Student phoebe = new Student(3, "Phoebe", "Buffay");
        Student joey = new Student(4, "Joey", "Tribbiani");
        Student chandler = new Student(5, "Chandler", "Bing");
        Student ross = new Student(6, "Ross", "Geller");
        Student gunther = new Student(7, "Gunther", "Smith");
        Student janice = new Student(8, "Janice", "Fox");

        // Створення об'єкту групи студентів зі старостою Rachel Green
        StudentsGroup group = new StudentsGroup(rachel);

        // Додавання всіх студентів до групи
        group.addStudent(rachel);
        group.addStudent(monica);
        group.addStudent(phoebe);
        group.addStudent(joey);
        group.addStudent(chandler);
        group.addStudent(ross);
        group.addStudent(gunther);
        group.addStudent(janice);

        // Зміна старости на Monica Geller
        group.setHead(monica);

        // Додавання завдання для всієї групи
        group.addAssignment("To study encapsulation");

        // Позначення завдання як виконаного для студентів
        group.markAssignmentAsDone(monica, "To study encapsulation");
        group.markAssignmentAsDone(phoebe, "To study encapsulation");
        group.markAssignmentAsDone(joey, "To study encapsulation");
        group.markAssignmentAsDone(chandler, "To study encapsulation");

        // Додавання завдання "First task" для студента Monica Geller та Phoebe Buffay
        group.getCompletedAssignments(monica).add("First task");
        group.getCompletedAssignments(phoebe).add("First task");

        // Виведення списку студентів як масив в консоль
        System.out.println("Students list:");
        for (Student student : group.getStudents()) {
            System.out.println(student.getId() + " " + student.getFirstName() + " " + student.getLastName());
        }

        System.out.println("Group head: " + group.getHead());

        // Список студентів, для яких хочемо вивести завдання
        List<Student> studentsToDisplayAssignments = new ArrayList<>();
        studentsToDisplayAssignments.add(monica);
        studentsToDisplayAssignments.add(phoebe);
        studentsToDisplayAssignments.add(joey);
        studentsToDisplayAssignments.add(chandler);

        // Виведення завдань групи та завдань, що були виконані для вибраних студентів
        System.out.println("Group assignments:");
        for (String assignment : group.getAssignments()) {
            System.out.println("  " + assignment);

            // Виведення студентів, які отримали завдання "To study encapsulation"
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
