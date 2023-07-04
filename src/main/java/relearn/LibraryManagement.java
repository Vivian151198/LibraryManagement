package relearn;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    Library library;
    List<User> userList;
    private static final int ADD_BOOK_COMMAND = 1;
    private static final int SEARCH_BOOK_COMMAND = 2;
    private static final int BORROW_BOOK_COMMAND = 3;

    IDatabase database; // Just depend on database interface, not specific database.

    public LibraryManagement() {
        this.library = new Library();

    }

    public void start() {
        initDatabase();
        initDocumentDatabase();
        showMenu();
        handleUserCommands();
    }

    public void showMenu() {
        System.out.println("---------MENU------------");
        System.out.println("1. Add book");
        System.out.println("2. Search book");
        System.out.println("3. Borrow book");
        System.out.println("4. Return book");
        System.out.println("5. Display book");
        System.out.println("6. Exit");
    }

    public void handleUserCommands() {
        Scanner scanner = new Scanner(System.in);
        boolean userWantContinue = true;
        do {
            System.out.println("What do you want?. Please type the number as the menu");
            int userType = scanner.nextInt();

            if (userType == ADD_BOOK_COMMAND) {
                addDocument();
            }

            if (userType == BORROW_BOOK_COMMAND) {
                borrowBook();
            }
            System.out.println("Do you want to continue? (1/0)");
            int userAnswer = scanner.nextInt();
            if (userAnswer == 1) {

                userWantContinue = true;
            } else {
                userWantContinue = false;
            }

        } while (userWantContinue);
    }

    public void addDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add the name of the document:");
        String name = scanner.nextLine();
        System.out.println("Please add the author of the document:");
        String author = scanner.nextLine();
        System.out.println("Please add the publish of the document:");
        String publishedAt = scanner.nextLine();
        System.out.println("Please add the type of the document:");
        String type = scanner.nextLine();
        System.out.println("Please add the quantity of the document:");
        Integer quantity = Integer.parseInt(scanner.nextLine());

        Document document = new Document();
        document.setName(name);
        document.setType(type);
        document.setQuantity(quantity);
        document.setPublishedAt(publishedAt);
        document.setAuthor(author);
        database.writeDocumentIntoDatabase(document);
    }

    public void borrowBook() {
        User user = askUserId();
        Scanner scanner = new Scanner(System.in);
        Document document = searchDocument();
        if (document != null) {
            if (document.quantity != 0) {
                System.out.println("What is the quantity book you want to borrow?");
                Integer quantity = Integer.parseInt(scanner.nextLine());
                if (document.quantity >= quantity) {

                    database.writeUserBorrowBookIntoDatabase(user, document);
                } else {
                    System.out.println("You can borrow maximum %d book" + document.quantity);
                    System.out.println("So, do you want continue borrow book?");
                }
            } else {
                System.out.println("Book isn't available!");
            }
        }
        else {
            System.out.println("This book is not available.");
        }
    }


    public Document searchDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the book you want to borrow?");
        String name = scanner.nextLine();
        library.listDocument = database.queryDocument();
        for (Document document : library.listDocument) {
            if (document.getName().equals(name)) {
                return document;
            }
        }
        return null;
    }

    public User askUserId() {
        userList = database.queryUsers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have account?");
        String answer = scanner.nextLine();
        if (answer.equals("Y")) {
            System.out.println("What is your id?");
            int userID = scanner.nextInt();
            for (User user : userList) {
                if (user.getId() == userID) {
                    return user;
                }
            }
        }
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your id card number?");
        String idCardNumber = scanner.nextLine();
        return new User(name, idCardNumber);
    }

    public void initDatabase() {
        this.database = new PostgresDatabase("jdbc:postgresql://localhost:5432/library",
                "postgres",
                "7432");
    }

    public void initDocumentDatabase() {
        library.listDocument = database.queryDocument();
        for (Document document : library.listDocument) {
            System.out.println(document.toString());
        }
    }
}
