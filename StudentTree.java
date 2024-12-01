package models;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class StudentTree {
    private Student root;

    // Add a student to the tree
    public void addStudent(int id, String name, double score) throws IllegalArgumentException {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Score must be between 0 and 10.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }

        Student newStudent = new Student(id, name, score);
        if (root == null) {
            root = newStudent;
        } else {
            addToTree(root, newStudent);
        }
    }

    private void addToTree(Student current, Student newStudent) {
        if (newStudent.getScore() <= current.getScore()) {
            if (current.left == null) {
                current.left = newStudent;
            } else {
                addToTree(current.left, newStudent);
            }
        } else {
            if (current.right == null) {
                current.right = newStudent;
            } else {
                addToTree(current.right, newStudent);
            }
        }
    }

    // Find a student by score
    public Student findStudent(double score) throws StudentNotFoundException {
        Student result = searchTree(root, score);
        if (result == null) {
            throw new StudentNotFoundException("No student found with score: " + score);
        }
        return result;
    }

    private Student searchTree(Student current, double score) {
        if (current == null) {
            return null;
        }
        if (current.getScore() == score) {
            return current;
        }
        return score < current.getScore()
            ? searchTree(current.left, score)
            : searchTree(current.right, score);
    }
    // Delete a student by score
    public void deleteStudent(double score) {
        root = removeNode(root, score);
    }

    private Student removeNode(Student current, double score) {
        if (current == null) {
            return null;
        }
        if (score < current.getScore()) {
            current.left = removeNode(current.left, score);
        } else if (score > current.getScore()) {
            current.right = removeNode(current.right, score);
        } else {
            // Node to delete found
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            // Replace node with the smallest node on the right subtree
            double minValue = findMinValue(current.right);
            current.right = removeNode(current.right, minValue);
            current = new Student(current.getId(), current.getName(), minValue);
        }
        return current;
    }
    private double findMinValue(Student node) {
        double minValue = node.getScore();
        while (node.left != null) {
            node = node.left;
            minValue = node.getScore();
        }
        return minValue;
    }
    // In-order traversal of the tree
    public void traverseInOrder() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        performInOrderTraversal(root);
    }
    private void performInOrderTraversal(Student node) {
        if (node != null) {
            performInOrderTraversal(node.left);
            System.out.println("ID: " + node.getId() + ", Name: " + node.getName() + ", Score: " + node.getScore());
            performInOrderTraversal(node.right);
        }
    }
}
class Student {
    private int id;
    private String name;
    private double score;
    Student left, right;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.left = null;
        this.right = null;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }
}
