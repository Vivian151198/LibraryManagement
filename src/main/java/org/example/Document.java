package org.example;

public class Document{
    private int id;
    private String name;
    private String type;//CD or Book
    private String author;
    private String publishedAt;
    private int quantity;

    Document(){

    }

    public Document(int id, String name, String type, String author, String publishedAt, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.author = author;
        this.publishedAt = publishedAt;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
