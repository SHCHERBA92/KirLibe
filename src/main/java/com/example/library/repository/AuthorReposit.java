package com.example.library.repository;

import com.example.library.entitys.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorReposit extends JpaRepository<AuthorBook, Long> {
    Optional<AuthorBook> findByLastNameAuthorAndFirstNameAuthor(String lastName, String firstName);
    List<AuthorBook> findAllByLastNameAuthor(String lastName);
    List<AuthorBook> findAllByLastNameAuthorContaining(String lastName);
}
