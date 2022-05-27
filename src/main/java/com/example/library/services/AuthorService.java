package com.example.library.services;

import com.example.library.entitys.AuthorBook;
import com.example.library.repository.AuthorReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorReposit authorReposit;

    public void addNewAuthor(String firstName, String lastName){
        AuthorBook tempAuthorBook = new AuthorBook();

        tempAuthorBook.setFirstNameAuthor(firstName);
        tempAuthorBook.setLastNameAuthor(lastName);

        var authorBook = authorReposit.findAll().stream()
                .filter(thisAuthor -> thisAuthor.equals(tempAuthorBook))
                .findFirst().orElse(tempAuthorBook);

        authorReposit.saveAndFlush(authorBook);
    }

    public void addNewAuthor(List<AuthorBook> authorBooks){
        authorReposit.saveAll(authorBooks);
    }
}
