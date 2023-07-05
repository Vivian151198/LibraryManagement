package application.models.document;

import application.models.Entity;
import io.github.thibaultmeyer.cuid.CUID;

public abstract class Document extends Entity {
    protected Document(CUID id) {
        super(id);
    }
}
