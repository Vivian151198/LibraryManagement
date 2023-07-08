package application.services;

import application.models.document.Author;
import application.models.document.AuthorResponse;
import application.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(){
        this.authorRepository = new AuthorRepository();
    }

    public List<AuthorResponse> getAllAuthor(){
        List<AuthorResponse> authorResponses = new ArrayList<>();
        List<Author> authors =  authorRepository.getAllAuthor();
        for (Author author : authors) {
            AuthorResponse authorResponse = new AuthorResponse(author.getId().toString(), author.getName());
            authorResponses.add(authorResponse);
        }
        return authorResponses;
    }
}
