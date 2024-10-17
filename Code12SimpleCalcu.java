// Calculator class with overloaded methods
class Calculator {
    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three numbers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add four numbers
    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}

// Main class to test the Calculator
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Testing the add methods
        System.out.println("Sum of 2 numbers (5 + 10): " + calculator.add(5, 10));
        System.out.println("Sum of 3 numbers (5 + 10 + 15): " + calculator.add(5, 10, 15));
        System.out.println("Sum of 4 numbers (5 + 10 + 15 + 20): " + calculator.add(5, 10, 15, 20));
    }
}
