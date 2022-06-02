package com.example.library.services;

import com.example.library.entitys.AuthorBook;
import com.example.library.repository.AuthorReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorReposit authorReposit;

    public void addNewAuthor(Set<AuthorBook> authorBooks){
        var tempAuthor = authorBooks.stream().map(authorBook -> {
            if (!authorReposit.findAll().isEmpty()){
                return authorReposit.findAll().stream().filter(authorBook1 -> authorBook1.equals(authorBook)).findFirst().orElse(authorBook);
            }else {
                return authorBook;
            }
        }).collect(Collectors.toSet());
        authorReposit.saveAll(tempAuthor);
    }

    public Set<AuthorBook> checkAuthor(Set<AuthorBook> authorBook){
        var allAuthors = authorReposit.findAll();
        var tempAuthors = authorBook.stream().collect(Collectors.toList());
        Set<AuthorBook> resultAuthors = new HashSet<>();

        for (AuthorBook tempAuthor : tempAuthors) {
            if (allAuthors.contains(tempAuthor)) {
                resultAuthors.add(authorReposit
                        .findByLastNameAuthorAndFirstNameAuthor(tempAuthor.getLastNameAuthor(), tempAuthor.getFirstNameAuthor())
                        .get());
            } else {
                resultAuthors.add(tempAuthor);
            }
        }
        return resultAuthors;
    }
}
