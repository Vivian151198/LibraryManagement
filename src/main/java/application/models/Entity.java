package application.models;

import io.github.thibaultmeyer.cuid.CUID;

public abstract class Entity {
    protected CUID id;

    protected Entity(CUID id) {
        if(id != null) {
            this.id = id;
        } else {
            this.id = CUID.randomCUID1();
        }
    }

    public CUID getId() {
        return id;
    }

}
