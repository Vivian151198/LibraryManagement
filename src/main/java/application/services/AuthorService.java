package application.services;

import application.models.document.Author;
import application.repositories.AuthorRepository;

import java.util.List;

public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(){
        this.authorRepository = new AuthorRepository();
    }

    public List<Author> getAllAuthor(){
        return authorRepository.getAllAuthor();
    }
}
