package application.models.document;

import application.models.base.CUID;

public class CD extends Document{

    public CD(CUID id, String name, String publishedAt, int quantity ){
        super(id, name, DocumentType.CD, publishedAt, quantity);
    }
    public CD(String name, String publishedAt, int quantity) {
        super(null, name, DocumentType.CD, publishedAt, quantity);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
