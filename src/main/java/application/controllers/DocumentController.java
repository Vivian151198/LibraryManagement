package application.controllers;

import application.models.document.Document;
import application.models.document.DocumentRequestBody;
import application.models.document.DocumentResponse;
import application.services.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    private DocumentService documentService;

   public DocumentController(){
       this.documentService = new DocumentService();
   }

   @GetMapping("/find")
   public DocumentResponse findOneDocumentByName(@RequestParam("name") String name){
       return this.documentService.findDocumentByName(name);
   }

   @GetMapping("/find-by-keyword")
   public List<DocumentResponse> findListDocumentByKeyword(@RequestParam("keyword") String keyword){
       return this.documentService.findListDocumentByKeyword(keyword);
   }

   @GetMapping("/book/get-all-list")
   public List<DocumentResponse> getAllBook(){
       return this.documentService.getAllBook();
   }

   @GetMapping("/cd/get-all-list")
   public List<DocumentResponse> getAlLCD(){
       return this.documentService.getAllCD();
   }

   @PostMapping("/add")
   public String addBook(@RequestBody DocumentRequestBody documentRequestBody){
      try {
          return documentService.addDocument(documentRequestBody);
      }catch (Exception e){
          return e.getMessage();
      }
   }
}
