package com.example.library.services;

import com.example.library.repository.PublisherReposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherReposit publisherReposit;
}
