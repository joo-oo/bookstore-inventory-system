import java.util.*;


public class Inventory {
    private LinkedList<Book> bookList = new LinkedList<>();
    private Queue<String> orderQueue = new LinkedList<>();
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean choosing = true;

        System.out.println("Welcome to the Bookstore Inventory Management System!");

        while (choosing) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Sort books by title");
            System.out.println("4. Search for a book by title");
            System.out.println("5. Add a customer order to the queue");
            System.out.println("6. Process the next customer order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    inventory.addBook(scanner);
                    break;
                case 2:
                    inventory.displayAllBooks();
                    break;
                case 3:
                    inventory.sortBooksByTitle();
                    break;
                case 4:
                    inventory.searchBookByTitle(scanner);
                    break;
                case 5:
                    inventory.addOrderToQueue(scanner);
                    break;
                case 6:
                    inventory.processNextOrder();
                    break;
                case 7:
                    choosing = false;
                    System.out.println("Thank you for using the Bookstore Inventory Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();


        System.out.print("Enter book author: ");
        String author = scanner.nextLine();


        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();


        double price;
        while (true) {
            try {
                System.out.print("Enter book price: ");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid number.");
        }
        }


        Book newBook = new Book(title, author, isbn, price);
        bookList.add(newBook);
        System.out.println("Book added successfully!");
    }


    public void displayAllBooks() {
        System.out.println("All Books in Inventory");
        if (bookList.isEmpty()) {
            System.out.println("No books in inventory.");
        } else {
            for (Book book : bookList) {
                System.out.println(book.toString());
        }
    }
    }




    public void sortBooksByTitle() {
        System.out.println("Sorting books by title...");


        if (bookList.size() < 2) {
            System.out.println("Books sorted successfully!");
            return;
        }
        int n = bookList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String title1 = bookList.get(j).getTitle();
                String title2 = bookList.get(j + 1).getTitle();
                if (title1.compareToIgnoreCase(title2) > 0) {
                    Book temp = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);
                }
            }
        }
        System.out.println("Books sorted successfully!");
    }

    public void searchBookByTitle(Scanner scanner) {
        System.out.print("Enter the title of the book to search for: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;

        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("Book found:");
                System.out.println(book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void addOrderToQueue(Scanner scanner) {
        System.out.print("Enter the title of the book to order: ");
        String title = scanner.nextLine();

        orderQueue.add(title);
        System.out.println("Order for \"" + title + "\" has been added to the queue.");
    }

    public void processNextOrder() {
        System.out.println("Processing next order...");


        if (orderQueue.isEmpty()) {
            System.out.println("No orders in the queue.");
        } else {
            String processedBook = orderQueue.poll();
            System.out.println("Processed order for: " + processedBook);
        }
    }
}

































