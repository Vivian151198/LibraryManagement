package application.domain.entities.user;

import application.domain.Entity;
import io.github.thibaultmeyer.cuid.CUID;

public abstract class User extends Entity {
    private final Role role;
    private final String name;
    protected User(CUID id, String name, Role role) {
        super(id);
        this.name = name;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
