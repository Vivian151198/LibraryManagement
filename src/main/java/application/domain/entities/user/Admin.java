package application.domain.entities.user;

import io.github.thibaultmeyer.cuid.CUID;

public class Admin extends User {
    protected Admin(CUID id, String name) {
        super(id, name, Role.ADMIN);
    }

    public static Admin create(CUID id, String name) {
        return new Admin(id, name);
    }

    public static Admin create(String name) {
        return new Admin(null, name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
