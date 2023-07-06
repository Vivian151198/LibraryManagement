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
        List<Document> documentList = documentRepository.findListDocumentByKeyword(keyword);
        if (documentList.size() == 0) {
            System.out.println("No document found!");
            return null;
        }

        return documentList;
    }

    public List<Book> getAllBook() {
        List<Book> bookList = documentRepository.getAllBook();
        if (bookList.size() == 0) {
            System.out.println("List book is null");
            return null;
        }

        return bookList;
    }

    public List<CD> getAllCD() {
        List<CD> cdList = documentRepository.getAllCD();
        if (cdList.size() == 0) {
            System.out.println("List cd is null");
            return null;
        }

        return cdList;
    }
}
