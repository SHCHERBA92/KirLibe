package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lib_books")
public class BookEntity {

    public BookEntity(String nameBook, String description, BigDecimal price, int countPage, int countBooks) {
        this.nameBook = nameBook;
        this.description = description;
        this.price = price;
        this.countPage = countPage;
        this.countBooks = countBooks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String nameBook;

    private String description;

    private BigDecimal price;

    private int countPage;

    private int countBooks;

    @ManyToMany
    @JoinTable(name = "lib_author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"))
    private Set<AuthorBook> authorsBook;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublishingEntity publishingEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusBook statusBook;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;
}
