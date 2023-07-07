package application.models.user;

import application.models.base.CUID;

public class Admin extends User {
    public Admin(CUID id, String name) {
        super(id, name, Role.ADMIN);
    }

    public Admin(String name) {
        super(null, name, Role.ADMIN);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
