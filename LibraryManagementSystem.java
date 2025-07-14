package Labs;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // New books are available by default
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, this book is currently unavailable.");
        }
    }

    void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();

        // Sample books to start with
        library.add(new Book("The Hobbit", "J.R.R. Tolkien", "1111"));
        library.add(new Book("1984", "George Orwell", "2222"));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", "3333"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add a new book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    for (Book book : library) {
                        book.displayDetails();
                    }
                    break;
                case 2:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    boolean foundBorrow = false;
                    for (Book book : library) {
                        if (book.isbn.equals(borrowIsbn)) {
                            book.borrowBook();
                            foundBorrow = true;
                            break;
                        }
                    }
                    if (!foundBorrow) System.out.println("Book not found.");
                    break;
                case 3:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    boolean foundReturn = false;
                    for (Book book : library) {
                        if (book.isbn.equals(returnIsbn)) {
                            book.returnBook();
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) System.out.println("Book not found.");
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.add(new Book(title, author, isbn));
                    System.out.println("Book added to library.");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
