package application.controllers;

import application.models.document.Document;
import application.services.DocumentService;

public class DocumentController {

    private DocumentService documentService;

   public DocumentController(){
       this.documentService = new DocumentService();
   }

   public Document findOneDocumentByName(String name){
       return documentService.findDocumentByName(name);
   }
}
