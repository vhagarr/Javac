// Abstract class Shape
abstract class Shape {
    public abstract double calculateArea(); // Abstract method
}

// Concrete class Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Area of the circle: πr²
    }
}

// Concrete class Rectangle
class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth; // Area of the rectangle: length * breadth
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5); // Create a Circle with radius 5
        Shape rectangle = new Rectangle(4, 6); // Create a Rectangle with length 4 and breadth 6

        System.out.printf("Area of Circle: %.2f%n", circle.calculateArea());
        System.out.printf("Area of Rectangle: %.2f%n", rectangle.calculateArea());
    }
}
