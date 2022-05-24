package com.example.library.repository;

import com.example.library.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposit extends JpaRepository<BookEntity, Long> {
}
