package cc.robotdreams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private List<String> completedAssignments;

    public Student(int id, String firstName, String lastName) {
        if (id <= 0) {
            throw new IllegalArgumentException("Error: Student ID must be greater than 0.");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Error: First name cannot be null or empty.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Error: Last name cannot be null or empty.");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        completedAssignments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getCompletedAssignments() {
        return completedAssignments;
    }

    // override toString() method for Student class
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

