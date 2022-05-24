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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String nameBook;

    private String description;

    private BigDecimal price;

    private int countPage;

    private int countBooks;

    @ManyToMany(mappedBy = "bookEntities", fetch = FetchType.EAGER)
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
