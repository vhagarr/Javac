// Base class
class Person {
    protected String name; protected int id;
    public Person(String name, int id) { this.name = name; this.id = id; }
    public void showDetails() { System.out.println("Name: " + name + "\nID: " + id); }
}

// Derived class Teacher
class Teacher extends Person {
    private String subject; private double salary;
    public Teacher(String name, int id, String subject, double salary) {
        super(name, id); this.subject = subject; this.salary = salary;
    }
    @Override
    public void showDetails() {
        super.showDetails(); System.out.println("Subject: " + subject + "\nSalary: $" + salary);
    }
}

// Derived class Student
class Student extends Person {
    private String grade; private String major;
    public Student(String name, int id, String grade, String major) {
        super(name, id); this.grade = grade; this.major = major;
    }
    @Override
    public void showDetails() {
        super.showDetails(); System.out.println("Grade: " + grade + "\nMajor: " + major);
    }
}

// Derived class AdminStaff
class AdminStaff extends Person {
    private String department; private String position;
    public AdminStaff(String name, int id, String department, String position) {
        super(name, id); this.department = department; this.position = position;
    }
    @Override
    public void showDetails() {
        super.showDetails(); System.out.println("Department: " + department + "\nPosition: " + position);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice Smith", 101, "Mathematics", 55000);
        Student student = new Student("John Doe", 202, "A", "Computer Science");
        AdminStaff admin = new AdminStaff("Jane Doe", 303, "Human Resources", "Manager");
        teacher.showDetails(); System.out.println();
        student.showDetails(); System.out.println();
        admin.showDetails();
    }
}
