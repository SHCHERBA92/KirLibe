package com.example.library.controllers;

import com.example.library.entitys.AuthorBook;
import com.example.library.entitys.BookEntity;
import com.example.library.entitys.PublishingEntity;
import com.example.library.services.AuthorService;
import com.example.library.services.BookService;
import com.example.library.services.PublisherService;
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
@RequestMapping("/")
//@AllArgsConstructor
public class RegistryBookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    private PublishingEntity publishingEntity = null;
    private Set<AuthorBook> authors = null;
    private BookEntity bookEntity = null;

    public RegistryBookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("registryBook")
    public String registryBook(Model model){

        return "registry_new_books";
    }


    @PostMapping("registryNewBook")
    public String registryNewBook(@RequestParam String nameBook, @RequestParam String descriptionBook,
                                  @RequestParam BigDecimal priceBook, @RequestParam Integer pageBook,
                                  @RequestParam Integer countBook, @RequestParam String nameAuthor,
                                  @RequestParam String namePublisher, @RequestParam String addressPublisher,
                                  @RequestParam String phonePublisher, Model model){

        publishingEntity = new PublishingEntity(namePublisher,addressPublisher,phonePublisher);

        authors = getListAuthors(nameAuthor);

        bookEntity = new BookEntity();
        bookEntity.setAuthorsBook(authors);
        bookEntity.setPublishingEntity(publishingEntity);

        bookEntity.setNameBook(nameBook);
        bookEntity.setCountBooks(countBook);
        bookEntity.setPrice(priceBook);
        bookEntity.setDescription(descriptionBook);
        bookEntity.setCountPage(pageBook);

        model.addAttribute("book", bookEntity);
        model.addAttribute("publisher", publishingEntity);
        model.addAttribute("author", authors);

        return "correct_registry";
    }

    @PostMapping("checkRegistryBook")
    public String checkRegistryBook(Model model){
        System.out.println(bookEntity.getNameBook());
        return "correct_registry";
    }

    private Set<AuthorBook> getListAuthors(String nameAuthor){
        var authors = nameAuthor.split(",");
        return Arrays.stream(authors).map(s -> {
            var temp = Arrays.stream(s.split(" ")).collect(Collectors.toList());
            String sureName = temp.remove(0);
            String lastName = temp.stream().collect(Collectors.joining(" "));
            return new AuthorBook(sureName,lastName);
        }).collect(Collectors.toSet());
    }
}
