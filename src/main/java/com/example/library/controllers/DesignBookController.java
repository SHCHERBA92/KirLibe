package com.example.library.controllers;

import com.example.library.DTO.BookShortDTO;
import com.example.library.entitys.AuthorBook;
import com.example.library.entitys.BookEntity;
import com.example.library.entitys.PublishingEntity;
import com.example.library.services.AuthorService;
import com.example.library.services.BookService;
import com.example.library.services.DesignService;
import com.example.library.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("design")
public class DesignBookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final DesignService designService;

    public DesignBookController(BookService bookService, AuthorService authorService, PublisherService publisherService, DesignService designService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.designService = designService;
    }

    @GetMapping("step_1")
    public String design(Model model) {
        var namesBook = getBookNames();
        var namesAuthor = getAuthorsNames();
        var namesPublisher = getPublisherNames();
        model.addAttribute("books", namesBook);
        model.addAttribute("authors", namesAuthor);
        model.addAttribute("publishers", namesPublisher);

        return "design_book";
    }

    @GetMapping("/step_2")
    public String getFromFindDesign(@RequestParam String nameOfBookOrAuthor, Model model) {
        var booksFromFind = designService.findAllBooksByName(nameOfBookOrAuthor);

        HashMap<BookShortDTO, String> mapOfFindingBook = getMapBookNameToAuthorLastName(booksFromFind.get(0));
        HashMap<BookShortDTO, String> mapOfOtherFindingBook = getMapBookNameToAuthorLastName(booksFromFind.get(1));

        model.addAttribute("mapFindingBook", mapOfFindingBook);
        model.addAttribute("mapOtherBooks", mapOfOtherFindingBook);

        return "design_book_step_2";
    }

    @GetMapping("/step_3/{id}")
    public String tiePersonToBook(@PathVariable("id") Long idBook, Model model) {

        return null;
    }

    private List<String> getBookNames() {
        var books = bookService.getPageOfBooks();
        return books.stream().map(BookEntity::getNameBook).collect(Collectors.toList());
    }

    private List<String> getAuthorsNames() {
        return authorService.getPageAuthors().stream()
                .map(authorBook -> authorBook.getLastNameAuthor() + " " + authorBook.getFirstNameAuthor())
                .collect(Collectors.toList());
    }

    private List<String> getPublisherNames() {
        return publisherService.getPagesOfPublishers().stream()
                .map(PublishingEntity::getNamePublisher)
                .collect(Collectors.toList());
    }

    private HashMap<BookShortDTO, String> getMapBookNameToAuthorLastName(List<BookEntity> bookEntities) {
        HashMap<BookShortDTO, String> map = new HashMap<>();
        for (BookEntity entity :
                bookEntities) {
            map.put(new BookShortDTO(entity.getId(), entity.getNameBook()),
                    entity.getAuthorsBook().stream()
                            .map(AuthorBook::getLastNameAuthor)
                            .collect(Collectors.joining(" , ")));
        }
        return map;
    }
}
