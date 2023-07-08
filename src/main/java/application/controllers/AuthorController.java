package application.controllers;

import application.models.document.Author;
import application.models.document.AuthorResponse;
import application.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(){
        this.authorService = new AuthorService();
    }

    @GetMapping("/get-all-list")
    public List<AuthorResponse> getAllAuthor(){
        return this.authorService.getAllAuthor();
    }
}
