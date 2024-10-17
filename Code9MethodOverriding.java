// Base class
abstract class Shape {
    public abstract double area(); // Abstract method to calculate area
}

// Derived class Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius; // Area of the circle: πr²
    }
}

// Derived class Rectangle
class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth; // Area of the rectangle: length * breadth
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5); // Create a Circle with radius 5
        Shape rectangle = new Rectangle(4, 6); // Create a Rectangle with length 4 and breadth 6

        System.out.printf("Area of Circle: %.2f%n", circle.area());
        System.out.printf("Area of Rectangle: %.2f%n", rectangle.area());
    }
}
