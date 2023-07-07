package application.models.document;

import application.models.Entity;
import application.models.base.CUID;

public abstract class Document extends Entity {

    private String name;
    private DocumentType type;
    private String publishedAt;
    private int quantity;
    protected Document(CUID id, String name, DocumentType type, String publishedAt, int quantity) {
        super(id);
        this.name = name;
        this.type = type;
        this.publishedAt = publishedAt;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public DocumentType getType() {
        return type;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", type=" + type +
                ", publishedAt='" + publishedAt + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
