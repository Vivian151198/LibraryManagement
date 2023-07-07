package application.models.document;


import application.models.base.CUID;

public class Book extends Document{

    public Book(CUID id, String name, String publishedAt, int quantity ){
        super(id, name, DocumentType.BOOK, publishedAt, quantity);
    }
    public Book(String name, String publishedAt, int quantity){
        super(null, name, DocumentType.BOOK, publishedAt, quantity);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
