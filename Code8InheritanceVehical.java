// Base class
class Vehicle {
    protected int speed;
    protected int fuelCapacity;

    public Vehicle(int speed, int fuelCapacity) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    public void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Derived class Car
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(int speed, int fuelCapacity, int numberOfDoors) {
        super(speed, fuelCapacity); // Call the constructor of Vehicle
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call displayDetails of Vehicle
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// Derived class Bike
class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(int speed, int fuelCapacity, boolean hasCarrier) {
        super(speed, fuelCapacity); // Call the constructor of Vehicle
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call displayDetails of Vehicle
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        Car car = new Car(120, 50, 4);
        Bike bike = new Bike(80, 15, true);

        System.out.println("Car Details:");
        car.displayDetails();
        System.out.println();

        System.out.println("Bike Details:");
        bike.displayDetails();
    }
}
