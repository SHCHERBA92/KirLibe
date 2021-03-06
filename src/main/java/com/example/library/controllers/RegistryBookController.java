package com.example.library.controllers;

import com.example.library.entitys.AuthorBook;
import com.example.library.entitys.BookEntity;
import com.example.library.entitys.PublishingEntity;
import com.example.library.services.AuthorService;
import com.example.library.services.DesignService;
import com.example.library.services.PublisherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/registry_book")
@Log4j2
public class RegistryBookController {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final DesignService designService;

    private PublishingEntity publishingEntity = null;
    private Set<AuthorBook> authors = null;
    private BookEntity bookEntity = null;

    public RegistryBookController(PublisherService publisherService, AuthorService authorService, DesignService designService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.designService = designService;
    }

    @GetMapping()
    public String registryBook(Model model) {

        return "registry_new_books";
    }


    @PostMapping("registryNewBook")
    public String registryNewBook(@RequestParam String nameBook, @RequestParam String descriptionBook,
                                  @RequestParam BigDecimal priceBook, @RequestParam Integer pageBook,
                                  @RequestParam Integer countBook, @RequestParam String nameAuthor,
                                  @RequestParam String namePublisher, @RequestParam String addressPublisher,
                                  @RequestParam String phonePublisher, Model model) {

        publishingEntity = new PublishingEntity(namePublisher, addressPublisher, phonePublisher);

        authors = getListAuthors(nameAuthor);

        bookEntity = new BookEntity(nameBook, descriptionBook, priceBook, pageBook, countBook);

        model.addAttribute("book", bookEntity);
        model.addAttribute("publisher", publishingEntity);
        model.addAttribute("authors", authors);

        return "correct_registry";
    }

    @PostMapping("checkRegistryBook")
    public String checkRegistryBook(Model model) {
        createCurrentBook(bookEntity, publishingEntity, authors);
        if (saveBook()) {
            return "redirect:/registry_book";
        } else {
            return null;
        }
    }

    private Set<AuthorBook> getListAuthors(String nameAuthor) {
        var compareAuthors = nameAuthor.split(", ");
        return Arrays.stream(compareAuthors).map(s -> {
            var temp = Arrays.stream(s.split(" ")).collect(Collectors.toList());
            String sureName = temp.remove(0);
            String lastName = temp.stream().collect(Collectors.joining(" "));
            return new AuthorBook(sureName, lastName);
        }).collect(Collectors.toSet());
    }

    private boolean saveBook() {
        try {
            publisherService.saveNewPublisher(this.publishingEntity);
            authorService.addNewAuthor(this.authors);
            designService.addNewBook(this.bookEntity);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private BookEntity createCurrentBook(BookEntity book, PublishingEntity publishingEntity, Set<AuthorBook> authors) {
        try {
            publishingEntity = publisherService.checkNewPublisher(publishingEntity);
            authors = authorService.checkAuthor(authors);
            book.setPublishingEntity(publishingEntity);
            book.setAuthorsBook(authors);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
        return book;
    }
}
