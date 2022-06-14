package com.example.library.services;

import com.example.library.entitys.BookEntity;
import com.example.library.repository.AuthorReposit;
import com.example.library.repository.BookReposit;
import com.example.library.repository.PublisherReposit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BookEntity> getPageOfBooks(){
        PageRequest pageRequest = PageRequest.of(0,5);
        return bookReposit.findAll(pageRequest).getContent();
    }
}
