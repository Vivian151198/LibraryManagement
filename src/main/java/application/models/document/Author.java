package application.models.document;

import application.models.Entity;
import application.models.base.CUID;

public class Author extends Entity {

    private String name;
    public Author(CUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
