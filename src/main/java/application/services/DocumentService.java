package application.services;

import application.models.document.Book;
import application.models.document.CD;
import application.models.document.Document;
import application.repositories.DocumentRepository;

import java.util.List;

public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService() {
        this.documentRepository = new DocumentRepository();
    }

    public Document findDocumentByName(String name) {
        if (name == null) {
            System.out.println("Name is null");
            return null;
        }
        return documentRepository.findOneDocumentByName(name);
    }

    public List<Document> findListDocumentByKeyword(String keyword) {
        if (keyword == null) {
            System.out.println("Keyword is null");
            return null;
        }
        return documentRepository.findListDocumentByKeyword(keyword);

    }

    public List<Book> getAllBook() {
        return documentRepository.getAllBook();
    }

    public List<CD> getAllCD() {
        return documentRepository.getAllCD();
    }
}
