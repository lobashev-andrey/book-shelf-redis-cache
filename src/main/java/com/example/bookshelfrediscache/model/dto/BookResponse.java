package com.example.bookshelfrediscache.model.dto;

import lombok.Data;

@Data
public class BookResponse {

    private Long id;

    private String title;

    private String author;

    private String categoryName;
}
