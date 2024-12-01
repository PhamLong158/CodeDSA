package models;

public class StudentManager {
    private String id;
    private String name;
    private double marks;
    private String rank;

    // Constructor
    public StudentManager(String id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            throw new IllegalArgumentException("Marks must be between 0 and 10.");
        }
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = assignRank();
    }

    // Assign rank based on marks
    private String assignRank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    // Update method to modify student details
    public void update(String name, double marks) {
        this.name = name;
        this.marks = marks;
        this.rank = assignRank(); // Update rank based on new marks
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }
}
