package com.example.library.repository;

import com.example.library.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReposit extends JpaRepository<BookEntity, Long> {
}
