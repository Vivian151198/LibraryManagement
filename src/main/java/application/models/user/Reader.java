package application.models.user;

import application.models.base.CUID;

public class Reader extends User {
    public Reader(CUID id, String name) {
        super(id, name, Role.READER);
    }

    public Reader(String name) {
        super(null, name, Role.READER);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
