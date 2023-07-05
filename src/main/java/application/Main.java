package application;

import application.models.user.Admin;
import application.models.user.Reader;
import application.models.user.User;
import io.github.thibaultmeyer.cuid.CUID;

public class Main {
    public static void main(String[] args) {
        User admin = new Admin("Khang");
        User admin2 = new Admin(CUID.fromString("cljoyfj0v00017896hlvktnuo"), "Khang 2");
        User reader1 = new Reader("Van");

        System.out.println(admin);
        System.out.println(admin2);
        System.out.println(reader1);
//        System.out.println(CUID.fromString("cljoyfj0v00017896hlvktnuo"));

    }
}
