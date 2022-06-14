package com.example.library.services;

import com.example.library.entitys.BookEntity;
import com.example.library.repository.BookReposit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookReposit bookReposit;

    public List<BookEntity> getPageOfBooks() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return bookReposit.findAll(pageRequest).getContent();
    }

}
