package com.example.library.repository;

import com.example.library.entitys.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorReposit extends JpaRepository<AuthorBook, Long> {
}
