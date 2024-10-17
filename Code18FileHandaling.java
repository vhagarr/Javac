import java.io.*;
import java.util.Scanner;

// Student class implementing Serializable
class Student implements Serializable {
    private String name;
    private int age;
    private double weight;
    private double height;
    private String city;
    private String phone;

    // Constructor
    public Student(String name, int age, double weight, double height, String city, String phone) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.city = city;
        this.phone = phone;
    }

    // Method to display student details
    public void display() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println("Height: " + height);
        System.out.println("City: " + city);
        System.out.println("Phone: " + phone);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "student.dat"; // File to store student data

        // Collecting student information
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter Height: ");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline

        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        // Creating a Student object
        Student student = new Student(name, age, weight, height, city, phone);

        // Writing student data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeUTF(student.name);
            dos.writeInt(student.age);
            dos.writeDouble(student.weight);
            dos.writeDouble(student.height);
            dos.writeUTF(student.city);
            dos.writeUTF(student.phone);
            System.out.println("Student data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading student data from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            String studentName = dis.readUTF();
            int studentAge = dis.readInt();
            double studentWeight = dis.readDouble();
            double studentHeight = dis.readDouble();
            String studentCity = dis.readUTF();
            String studentPhone = dis.readUTF();

            // Displaying student data
            Student retrievedStudent = new Student(studentName, studentAge, studentWeight, studentHeight, studentCity, studentPhone);
            retrievedStudent.display();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner resource
        }
    }
}
