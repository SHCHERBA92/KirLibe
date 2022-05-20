package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "bookEntities", fetch = FetchType.EAGER)
    private Set<AuthorBook> authorsBook;

    private int countPage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusBook statusBook;

    private int countBooks;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
