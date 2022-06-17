package com.example.library.services;

import com.example.library.entitys.BookEntity;
import com.example.library.repository.AuthorReposit;
import com.example.library.repository.BookReposit;
import com.example.library.repository.PublisherReposit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DesignService {
    private final BookReposit bookReposit;
    private final AuthorReposit authorReposit;
    private final PublisherReposit publisherReposit;

    public DesignService(BookReposit bookReposit, AuthorReposit authorReposit, PublisherReposit publisherReposit) {
        this.bookReposit = bookReposit;
        this.authorReposit = authorReposit;
        this.publisherReposit = publisherReposit;
    }

    public void addNewBook(BookEntity bookEntity) {
        var tempPublic = bookEntity.getPublishingEntity();

        if (!publisherReposit.findAll().contains(tempPublic)) {
            publisherReposit.save(tempPublic);
        }
        bookReposit.save(bookEntity);
    }


    public ArrayList<List<BookEntity>> findAllBooksByName(String nameBookOfAuthor) {
        var listOfBook = Collections.EMPTY_LIST;
        var otherListOfBook = Collections.EMPTY_LIST;

        listOfBook = bookReposit.findAllByNameBook(nameBookOfAuthor);
        otherListOfBook = bookReposit.findAllByNameBookContaining(nameBookOfAuthor);

        ArrayList<List<BookEntity>> lists = new ArrayList<>();
        lists.add(listOfBook);
        lists.add(otherListOfBook);

        return lists;
    }
}
