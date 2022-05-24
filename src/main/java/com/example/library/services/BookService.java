package com.example.library.services;

import com.example.library.entitys.BookEntity;
import com.example.library.repository.BookReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
    private final BookReposit bookReposit;

    public void addNewBook(BookEntity bookEntity){
        BookEntity entity = new BookEntity();

        entity.setNameBook(bookEntity.getNameBook());
        entity.setDescription(bookEntity.getDescription());
        entity.setAuthorsBook(bookEntity.getAuthorsBook());
        entity.setCountPage(bookEntity.getCountPage());
        entity.setPublishingEntity(bookEntity.getPublishingEntity());
        entity.setPrice(bookEntity.getPrice());

        var book = bookReposit.findAll().stream()
                .filter(currentBook -> currentBook.equals(entity))
                .findFirst()
                .orElse(entity);

        bookReposit.saveAndFlush(book);
    }
}
