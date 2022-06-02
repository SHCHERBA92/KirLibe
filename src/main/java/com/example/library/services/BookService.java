package com.example.library.services;

import com.example.library.entitys.BookEntity;
import com.example.library.repository.AuthorReposit;
import com.example.library.repository.BookReposit;
import com.example.library.repository.PublisherReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookReposit bookReposit;
    private final AuthorReposit authorReposit;
    private final PublisherReposit publisherReposit;

    public void addNewBook(BookEntity bookEntity) {
        var tempPublic = bookEntity.getPublishingEntity();

        if (!publisherReposit.findAll().contains(tempPublic)) {
            publisherReposit.save(tempPublic);
        }

        bookReposit.save(bookEntity);
    }
}
