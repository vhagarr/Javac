// Interface Drawable
interface Drawable {
    void draw(); // Method to be implemented by the classes
}

// Class Circle that implements Drawable
class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

// Class Rectangle that implements Drawable
class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}

// Main class to test the interface implementation
public class Main {
    public static void main(String[] args) {
        Drawable circle = new Circle(); // Create a Circle object
        Drawable rectangle = new Rectangle(); // Create a Rectangle object

        circle.draw(); // Call draw method on Circle
        rectangle.draw(); // Call draw method on Rectangle
    }
}
