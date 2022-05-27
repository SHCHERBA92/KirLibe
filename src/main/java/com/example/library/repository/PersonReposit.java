package com.example.library.repository;

import com.example.library.entitys.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonReposit extends JpaRepository<Person, Long> {
}
