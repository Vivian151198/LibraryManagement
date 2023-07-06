package application.services;

import application.models.document.Document;
import application.repositories.DocumentRepository;

public class DocumentService {

    private DocumentRepository documentRepository;

    public DocumentService() {
        this.documentRepository = new DocumentRepository();
    }

    public Document findDocumentByName(String name){
        if(name == null){
            System.out.println("Name is null");
            return null;
        }
        return documentRepository.findOneDocumentByName(name);
    }
}
