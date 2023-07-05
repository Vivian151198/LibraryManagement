package application.models.user;

import application.models.Entity;
import io.github.thibaultmeyer.cuid.CUID;

public abstract class User extends Entity {
    private Role role;
    private String name;
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
