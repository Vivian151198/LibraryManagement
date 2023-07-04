package application;

import application.domain.entities.user.Admin;
import application.domain.entities.user.Reader;
import application.domain.entities.user.User;

public class Main {
    public static void main(String[] args) {
        User admin = Admin.create("Khang");
        User reader1 = Reader.create("Van");

        System.out.println(admin);
        System.out.println(reader1);
    }
}
