package com.example.bookshelfrediscache.mapper;

import com.example.bookshelfrediscache.model.Book;
import com.example.bookshelfrediscache.model.dto.BookListResponse;
import com.example.bookshelfrediscache.model.dto.BookResponse;
import com.example.bookshelfrediscache.model.dto.UpsertBookRequest;
import com.example.bookshelfrediscache.service.BookService;
import com.example.bookshelfrediscache.service.CategoryService;
import com.example.bookshelfrediscache.util.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final CategoryService categoryService;
    private final BookService bookService;

    public BookResponse bookToResponse(Book book){
        BookResponse response = new BookResponse();

        response.setId(book.getId());
        response.setAuthor(book.getAuthor());
        response.setTitle(book.getTitle());
        response.setCategoryName(book.getCategory().getName());

        return response;
    }

    public BookListResponse bookListToListResponse(List<Book> books){
        BookListResponse response = new BookListResponse();
        response.setBooks(books.stream().map(this::bookToResponse).toList());

        return response;
    }

    public Book requestToBook(UpsertBookRequest request){
        Book book = new Book();

        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());

        book.setCategory(categoryService.createOrGet(request.getCategoryName()));

        return book;
    }

    public Book requestToBook(Long id, UpsertBookRequest request){
        Book book = requestToBook(request);
        book.setId(id);

        return book;
    }
}
