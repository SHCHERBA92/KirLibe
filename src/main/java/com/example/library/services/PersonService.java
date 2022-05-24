package com.example.library.services;

import com.example.library.repository.PersonReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonReposit personReposit;
}
