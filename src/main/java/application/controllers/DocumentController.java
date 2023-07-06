package application.controllers;

import application.models.document.Book;
import application.models.document.CD;
import application.models.document.Document;
import application.services.DocumentService;

import java.util.List;

public class DocumentController {

    private DocumentService documentService;

   public DocumentController(){
       this.documentService = new DocumentService();
   }

   public Document findOneDocumentByName(String name){
       return documentService.findDocumentByName(name);
   }

   public List<Document> findListDocumentByKeyword(String keyword){
       return documentService.findListDocumentByKeyword(keyword);
   }

   public List<Book> getAllBook(){
       return documentService.getAllBook();
   }

   public List<CD> getAlLCD(){
       return documentService.getAllCD();
   }
}
