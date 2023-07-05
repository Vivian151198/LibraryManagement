package application.models.document;

import application.models.Entity;
import io.github.thibaultmeyer.cuid.CUID;

public class Author extends Entity {
    protected Author(CUID id) {
        super(id);
    }
}
