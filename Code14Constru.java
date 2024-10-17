// Book class
class Book {
    private String title;
    private String author;
    private double price;

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Copy constructor
    public Book(Book another) {
        this.title = another.title;
        this.author = another.author;
        this.price = another.price;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

// Main class to test the Book class
public class Main {
    public static void main(String[] args) {
        // Creating a Book object using the parameterized constructor
        Book originalBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        System.out.println("Original Book Details:");
        originalBook.displayBookDetails();
        System.out.println();

        // Creating a Book object using the copy constructor
        Book copiedBook = new Book(originalBook);
        System.out.println("Copied Book Details:");
        copiedBook.displayBookDetails();
    }
}
