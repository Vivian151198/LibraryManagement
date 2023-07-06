package application.views;

import application.controllers.AuthorController;
import application.controllers.DocumentController;
import application.controllers.UserController;
import application.models.document.Author;
import application.models.document.Book;
import application.models.document.CD;
import application.models.document.Document;
import application.models.user.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private UserController userController;
    private DocumentController documentController;
    private AuthorController authorController;

    public LibraryManagement() {

        userController = new UserController();
        documentController = new DocumentController();
        authorController = new AuthorController();
    }

    public void start() {
        this.login();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to library management!");
//        System.out.println("Enter your ID to sign in: ");
//        String userId = scanner.nextLine();
//        User user = userController.findOneById(userId);
//        System.out.println(user);

//        System.out.println("===========");
//        List<Document> documentList = documentController.findListDocumentByKeyword("h");
//        for (Document document : documentList) {
//            System.out.println(document);
//        }
//
//        System.out.println("============");
//        List<Book> bookList = documentController.getAllBook();
//        for (Book book : bookList) {
//            System.out.println(book);
//        }
//
//        System.out.println("============");
//        List<CD> cdList = documentController.getAlLCD();
//        for (CD cd : cdList) {
//            System.out.println(cd);
//        }

        System.out.println("==========");
        List<Author> authorList = authorController.getAllAuthor();
        for (Author author : authorList) {
            System.out.println(author);
        }
    }
}
