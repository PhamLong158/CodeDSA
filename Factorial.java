package models;

// Factorial.java
public class Factorial {
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        int result = fact.factorial(5);
        System.out.println("Factorial of 5 is: " + result);
    }
}
