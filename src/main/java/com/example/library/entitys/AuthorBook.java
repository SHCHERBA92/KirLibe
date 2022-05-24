package com.example.library.entitys;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lib_author")
public class AuthorBook {
    @Id
    @Column(name = "author_id")
    private Long id;

    private String lastNameAuthor;

    private String firstNameAuthor;

    @ManyToMany
    @JoinTable(name = "lib_author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookEntity> bookEntities;

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
