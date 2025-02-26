import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int bookId;
    private boolean isIssued;

    public Book(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isIssued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued);
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        for (Book book : books) {
            book.displayBook();
        }
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    library.addBook(new Book(title, author, bookId));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = scanner.nextInt();
                    Book issueBook = library.findBook(issueId);
                    if (issueBook != null) {
                        issueBook.issueBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    Book returnBook = library.findBook(returnId);
                    if (returnBook != null) {
                        returnBook.returnBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
