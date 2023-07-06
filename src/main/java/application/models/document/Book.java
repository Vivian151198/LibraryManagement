package application.models.document;

import io.github.thibaultmeyer.cuid.CUID;

public class Book extends Document{

    public Book(CUID id,String name, String publishedAt, int quantity ){
        super(id, name, DocumentType.BOOK, publishedAt, quantity);
    }
    public Book(String name, String publishedAt, int quantity){
        super(null, name, DocumentType.BOOK, publishedAt, quantity);
    }

}
