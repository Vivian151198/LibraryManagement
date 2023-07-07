package application.models.user;

import application.models.Entity;
import application.models.base.CUID;

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
                "id='" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                '}';
    }
}
