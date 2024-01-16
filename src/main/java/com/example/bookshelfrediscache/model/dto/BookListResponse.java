package com.example.bookshelfrediscache.model.dto;

import com.example.bookshelfrediscache.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class BookListResponse {

    private List<BookResponse> books;
}
