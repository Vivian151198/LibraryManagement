package application.domain.entities.document;

import application.domain.Entity;
import io.github.thibaultmeyer.cuid.CUID;

public class Author extends Entity {
    protected Author(CUID id) {
        super(id);
    }
}
