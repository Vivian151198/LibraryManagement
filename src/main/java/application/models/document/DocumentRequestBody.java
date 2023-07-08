package application.models.document;

public class DocumentRequestBody {
    private String name;

    private String type;

    private String publishedAt;


    private int quantity;

    public DocumentRequestBody(String name, String type, String publishedAt, int quantity) {
        this.name = name;
        this.type = type;
        this.publishedAt = publishedAt;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
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
        return "DocumentRequestBody{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
