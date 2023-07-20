package cc.robotdreams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentsGroup {
    private Student head;
    private Set<Student> students;
    private List<String> assignments;
    private Map<Student, List<String>> completedAssignments;

    public StudentsGroup(Student head) {
        if (head == null) {
            throw new IllegalArgumentException("Error: Group must have a head student.");
        }
        this.head = head;
        this.students = new LinkedHashSet<>();
        assignments = new ArrayList<>();
        //completedAssignments = new HashMap<>();
        this.completedAssignments = new HashMap<>();
        students.add(head);
        completedAssignments.put(head, new ArrayList<>());
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Error: Student cannot be null.");
        }
        if (!student.equals(head)) {
            students.add(student);
            completedAssignments.put(student, new ArrayList<>());
        }
    }

    public String getHead() {
        return head.toString();
    }

    public void setHead(Student head) {
        if (head == null) {
            throw new IllegalArgumentException("Error: Group must have a head student.");
        }
        this.head = head;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void addAssignment(String assignment) {
        if (assignment == null || assignment.isEmpty()) {
            throw new IllegalArgumentException("Error: Assignment cannot be null or empty.");
        }
        assignments.add(assignment);
        for (Student student : students) {
            completedAssignments.putIfAbsent(student, new ArrayList<>());
        }
    }

    public void removeAssignment(String assignment) {
        if (assignment == null || assignment.isEmpty()) {
            throw new IllegalArgumentException("Error: Assignment cannot be null or empty.");
        }
        if (assignments.contains(assignment)) {
            assignments.remove(assignment);
            for (List<String> completed : completedAssignments.values()) {
                completed.remove(assignment);
            }
        }
    }

    public void markAssignmentAsDone(Student student, String assignment) {
        if (student == null || assignment == null || assignment.isEmpty()) {
            throw new IllegalArgumentException("Error: Invalid student or assignment.");
        }
        if (students.contains(student) && assignments.contains(assignment)) {
            List<String> completed = completedAssignments.get(student);
            completed.add(assignment);
        } else {
            throw new IllegalArgumentException("Error: Student or assignment not found.");
        }
    }

    public List<String> getCompletedAssignments(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Error: Invalid student.");
        }
        return completedAssignments.getOrDefault(student, new ArrayList<>());
    }


    // A method that returns a list of students who received a specific task
    public List<Student> getStudentsWithAssignment(String assignment) {
        List<Student> studentsWithAssignment = new ArrayList<>();
        for (Student student : students) {
            if (completedAssignments.get(student).contains(assignment)) {
                studentsWithAssignment.add(student);
            }
        }
        return studentsWithAssignment;
    }
}
