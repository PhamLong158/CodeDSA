package models;

public class Student {
    private String id;
    private String name;
    private double marks;
    private String rank;

    // Constructor
    public Student(String id, String name, double marks) {
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

    // Setters (if needed)
    public void setMarks(double marks) {
        if (marks < 0 || marks > 10) {
            throw new IllegalArgumentException("Marks must be between 0 and 10.");
        }
        this.marks = marks;
        this.rank = assignRank(); // Update rank whenever marks change
    }

    // Override toString to display student details
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", rank='" + rank + '\'' +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test cases
        Student student1 = new Student("S01", "Alice", 8.5);
        Student student2 = new Student("S02", "Bob", 4.5);

        System.out.println(student1);
        System.out.println(student2);

        // Update marks and see changes in rank
        student2.setMarks(7.0);
        System.out.println(student2);
    }
}
