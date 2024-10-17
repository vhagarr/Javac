// Class to demonstrate exception handling
public class Main {
    
    // Method to perform division
    public static double divide(int numerator, int denominator) {
        return numerator / denominator; // This may throw ArithmeticException
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0; // Denominator is zero

        try {
            // Attempt to divide
            double result = divide(num1, num2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // This block always executes
            System.out.println("Execution completed.");
        }

        // Another example with valid input
        num2 = 2; // Changing denominator to a valid value
        try {
            double result = divide(num1, num2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
