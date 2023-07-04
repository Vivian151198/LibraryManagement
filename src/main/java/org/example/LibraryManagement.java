package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private IDatabase database;
    Library library;
    private static final int ADD_BOOK_COMMAND = 1;
    private static final int SEARCH_BOOK_COMMAND = 2;
    private static final int BORROW_BOOK_COMMAND = 3;

    LibraryManagement() {
        this.library = new Library();
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
        do{
            System.out.println("What do you want?. Please type the number as the menu");
            int userType = scanner.nextInt();

            if (userType == ADD_BOOK_COMMAND) {
                addDocument();
            }
//            if (userType == SEARCH_BOOK_COMMAND) {
//                handleSearchDocuments();
//            }
//            if (userType == BORROW_BOOK_COMMAND) {
//                borrowBook();
//            }
            System.out.println("Do you want to continue? (1/0)");
            int userAnswer = scanner.nextInt();
            if(userAnswer == 1){

                userWantContinue = true;
            }
            else {
                userWantContinue = false;
            }

        }while (userWantContinue);
    }
    public void addDocument() {
        Document document = new Document();
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

        document.setName(name);
        document.setAuthor(author);
        document.setType(type);
        document.setPublishedAt(publishedAt);
        document.setQuantity(quantity);
        library.listDocument.add(document);
        database.writeDocumentIntoDB(document);
    }

    public void initUsersData(){
        List<User> userList = database.queryUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
    public void initDocumentsData(){
        library.listDocument = database.queryDocuments();
        for (Document document : library.listDocument) {
            System.out.println(document.toString());
        }
    }
    public void start() {
        this.initDatabaseConnection();
        initDocumentsData();
        initUsersData();
        showMenu();
        handleUserCommands();
    }

    private void initDatabaseConnection() {
        this.database = new PostgresDatabase(
                "jdbc:postgresql://localhost:5432/librarymanagement",
                "postgres",
                "7432"
        );
    }
}
