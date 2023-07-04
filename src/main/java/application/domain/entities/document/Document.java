package application.domain.entities.document;

import application.domain.Entity;
import io.github.thibaultmeyer.cuid.CUID;

public abstract class Document extends Entity {
    protected Document(CUID id) {
        super(id);
    }
}
