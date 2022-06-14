package com.example.library.controllers;

import com.example.library.services.AuthorService;
import com.example.library.services.BookService;
import com.example.library.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("design")
public class DesignBookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public DesignBookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping
    public String design(Model model){
        var namesBook = getBookNames();
        var namesAuthor = getAuthorsNames();
        var namesPublisher = getPublisherNames();
        model.addAttribute("books", namesBook);
        model.addAttribute("authors", namesAuthor);
        model.addAttribute("publishers", namesPublisher);

        return "design_book";
    }

    private List<String> getBookNames(){
        var books = bookService.getPageOfBooks();
        return books.stream().map(book -> book.getNameBook()).collect(Collectors.toList());
    }

    private List<String> getAuthorsNames(){
        return authorService.getPageAuthors().stream()
                .map(authorBook -> authorBook.getLastNameAuthor() + authorBook.getFirstNameAuthor())
                .collect(Collectors.toList());
    }

    private List<String> getPublisherNames(){
        return publisherService.getPagesOfPublishers().stream()
                .map(publishingEntity -> publishingEntity.getNamePublisher())
                .collect(Collectors.toList());
    }
}
