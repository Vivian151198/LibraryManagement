package application.services;

import application.models.document.*;
import application.repositories.DocumentRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService() {
        this.documentRepository = new DocumentRepository();
    }

    public DocumentResponse findDocumentByName(String name) {
        if (name == null) {
            return null;
        }
        Document document =  documentRepository.findOneDocumentByName(name);
        return new DocumentResponse(document.getId().toString(), document.getName(), document.getType(), document.getPublishedAt(), document.getQuantity());
    }

    public List<DocumentResponse> findListDocumentByKeyword(String keyword) {
        List<DocumentResponse> documentResponses = new ArrayList<>();
        if (keyword == null) {
            return null;
        }
        List<Document> documentList = documentRepository.findListDocumentByKeyword(keyword);
        for (Document document : documentList) {
            DocumentResponse documentResponse = new DocumentResponse(document.getId().toString(), document.getName(), document.getType(), document.getPublishedAt(), document.getQuantity());
            documentResponses.add(documentResponse);
        }
        return documentResponses;
    }

    public List<DocumentResponse> getAllBook() {
        List<DocumentResponse> documentResponses = new ArrayList<>();
        List<Book> bookList = documentRepository.getAllBook();
        for (Book book : bookList) {
            DocumentResponse documentResponse = new DocumentResponse(book.getId().toString(), book.getName(), book.getType(), book.getPublishedAt(), book.getQuantity());
            documentResponses.add(documentResponse);
        }
        return documentResponses;
    }

    public List<DocumentResponse> getAllCD() {
        List<DocumentResponse> documentResponses = new ArrayList<>();
        List<CD> cdList = documentRepository.getAllCD();
        for (CD cd : cdList) {
            DocumentResponse documentResponse = new DocumentResponse(cd.getId().toString(), cd.getName(), cd.getType(), cd.getPublishedAt(), cd.getQuantity());
            documentResponses.add(documentResponse);
        }
        return documentResponses;
    }

    public String addDocument(DocumentRequestBody documentRequestBody) throws Exception {
        String name = documentRequestBody.getName();
        DocumentType type = DocumentType.valueOf(documentRequestBody.getType());
        String publishedAt = documentRequestBody.getPublishedAt();
        int quantity = documentRequestBody.getQuantity();

        if(type != DocumentType.CD && type != DocumentType.BOOK) {
            throw new Exception("Type is invalid");
        }
        Document document;

        if(type == DocumentType.BOOK) {
            document = new Book(name, publishedAt, quantity);
        } else {
            document = new CD(name, publishedAt, quantity);
        }

        document = documentRepository.addDocument(document);
        if(document == null){
            throw new Exception("Add document failed");
        }
       return "ADD DOCUMENT SUCCESSFULLY!";
    }
}
