package application.views;

import application.controllers.DocumentController;
import application.controllers.UserController;
import application.views.screens.BaseScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagement extends BaseScreen implements ActionListener {
    private final UserController userController;
    private final DocumentController documentController;

    public LibraryManagement() {
        super();
        userController = new UserController();
        documentController = new DocumentController();
    }

    public void start() {
        this.visible();
    }

    public void visible() {
        this.showLogin();
    }

    public void showLogin() {
        JLabel label = new JLabel("Library management");
        label.setBounds(1024 / 2 - 80, 720 / 2 - 40, 160, 30);

        JTextField textField = new JTextField("User id");
        textField.setBounds(1024 / 2 - 100, 720 / 2 - 10, 180, 30);

        JButton button = new JButton("Login");
        button.setBounds(1024 / 2 - 100, 720 / 2 + 20, 180, 30);

        button.addActionListener(e -> {
            String userInput = textField.getText();
            System.out.println(userInput);
            this.frame.getContentPane().removeAll();
            this.frame.getContentPane().repaint();
            this.showMain();
        });

        this.frame.getContentPane().add(textField);
        this.frame.getContentPane().add(label);
        this.frame.getContentPane().add(button);
    }

    public void showMain() {
        JLabel label = new JLabel("You want to find a book");
        label.setBounds(1024 / 2, 720 / 2 - 40, 200, 30);

        JTextField textField = new JTextField("The why");
        textField.setBounds(1024 / 2, 720 / 2 - 10, 180, 30);

        JButton button = new JButton("find");
        button.setBounds(1024 / 2, 720 / 2 + 20, 180, 30);

        this.frame.getContentPane().add(textField);
        this.frame.getContentPane().add(label);
        this.frame.getContentPane().add(button);
        this.frame.getContentPane().revalidate();
        this.frame.getContentPane().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
