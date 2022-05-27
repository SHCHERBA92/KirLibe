package com.example.library.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {
    private String nameBook;

    private String description;

    private BigDecimal price;

    private int countPage;

    private int countBooks;
}
