// Student class
class Student {
    private String name;
    private int rollNumber;
    private String course;

    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.rollNumber = 0;
        this.course = "Not Assigned";
    }

    // Parameterized constructor
    public Student(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

// Main class to test the Student class
public class Main {
    public static void main(String[] args) {
        // Using the default constructor
        Student student1 = new Student();
        System.out.println("Student 1 Details (Default Constructor):");
        student1.displayDetails();
        System.out.println();

        // Using the parameterized constructor
        Student student2 = new Student("Alice Johnson", 101, "Computer Science");
        System.out.println("Student 2 Details (Parameterized Constructor):");
        student2.displayDetails();
    }
}
