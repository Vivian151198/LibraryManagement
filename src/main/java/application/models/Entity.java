package application.models;

import application.models.base.CUID;

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
