package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lib_author")
public class AuthorBook {

    public AuthorBook(String lastNameAuthor, String firstNameAuthor) {
        this.lastNameAuthor = lastNameAuthor;
        this.firstNameAuthor = firstNameAuthor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    private String lastNameAuthor;

    private String firstNameAuthor;

    @ManyToMany(mappedBy = "authorsBook", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookEntity> bookEntities;

//    public void addBooks(BookEntity book){
//        bookEntities.add(book);
//        book.getAuthorsBook().add(this);
//    }
//
//    public void removeBooks(BookEntity book){
//        bookEntities.remove(book);
//        book.getAuthorsBook().remove(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return Objects.equals(lastNameAuthor, that.lastNameAuthor) && Objects.equals(firstNameAuthor, that.firstNameAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastNameAuthor, firstNameAuthor);
    }
}
