package application.controllers;

import application.models.document.Author;
import application.services.AuthorService;

import java.util.List;

public class AuthorController {

    private AuthorService authorService;

    public AuthorController(){
        this.authorService = new AuthorService();
    }

    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }
}
