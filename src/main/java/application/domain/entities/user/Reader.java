package application.domain.entities.user;

import io.github.thibaultmeyer.cuid.CUID;

public class Reader extends User {
    protected Reader(CUID id, String name) {
        super(id, name, Role.READER);
    }

    public static Reader create(CUID id, String name) {
        return new Reader(id, name);

    }

    public static Reader create(String name) {
        return new Reader(null, name);
    }
}
