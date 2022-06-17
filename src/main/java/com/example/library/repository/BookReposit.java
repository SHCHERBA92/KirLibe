package com.example.library.repository;

import com.example.library.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookReposit extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findAllByNameBookStartingWith(String name);
    List<BookEntity> findAllByNameBookContaining(String name);
    Optional<BookEntity> findByNameBook(String name);
    List<BookEntity> findAllByNameBook(String name);
}
