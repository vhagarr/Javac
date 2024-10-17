// Base class
class Book {
    protected String title;
    protected String author;
    protected String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

// Derived class EBook
class EBook extends Book {
    private double fileSize; // in MB

    public EBook(String title, String author, String isbn, double fileSize) {
        super(title, author, isbn); // Call the constructor of Book
        this.fileSize = fileSize;
    }

    public void download() {
        System.out.println("Downloading " + title + " (" + fileSize + " MB)...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Call displayInfo of Book
        System.out.println("File Size: " + fileSize + " MB");
    }
}

// Derived class PrintedBook
class PrintedBook extends Book {
    private double weight; // in grams

    public PrintedBook(String title, String author, String isbn, double weight) {
        super(title, author, isbn); // Call the constructor of Book
        this.weight = weight;
    }

    public void ship() {
        System.out.println("Shipping " + title + " (" + weight + " grams)...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Call displayInfo of Book
        System.out.println("Weight: " + weight + " grams");
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        EBook eBook = new EBook("Digital Fortress", "Dan Brown", "978-3-16-148410-0", 1.5);
        PrintedBook printedBook = new PrintedBook("The Da Vinci Code", "Dan Brown", "978-3-16-148410-1", 300);

        System.out.println("EBook Details:");
        eBook.displayInfo();
        eBook.download();
        System.out.println();

        System.out.println("PrintedBook Details:");
        printedBook.displayInfo();
        printedBook.ship();
    }
}
