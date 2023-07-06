package application.views;

import application.controllers.UserController;
import application.models.user.User;

import java.util.Scanner;

public class LibraryManagement {
    private UserController userController;

    public LibraryManagement() {
        userController = new UserController();
    }

    public void start() {
        this.login();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to library management!");
        System.out.println("Enter your ID to sign in: ");
        String userId = scanner.nextLine();
        User user = userController.findOneById(userId);
        System.out.println(user);
    }
}
