package com.example.bookshelfrediscache.controller;

import com.example.bookshelfrediscache.mapper.BookMapper;
import com.example.bookshelfrediscache.model.Book;
import com.example.bookshelfrediscache.model.dto.BookListResponse;
import com.example.bookshelfrediscache.model.dto.BookResponse;
import com.example.bookshelfrediscache.model.dto.ErrorResponse;
import com.example.bookshelfrediscache.model.dto.UpsertBookRequest;
import com.example.bookshelfrediscache.service.BookService;
import com.example.bookshelfrediscache.util.BeanUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/bookshelf")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService service;
    private final BookMapper mapper;

    @GetMapping("/{name}")
    public ResponseEntity<BookListResponse> findAllByCategoryName(@PathVariable String name){       ;

        return ResponseEntity.ok(
                mapper.bookListToListResponse(
                service.findAllByCategoryName(name)));
    }

    @GetMapping
    public ResponseEntity<BookResponse> findByTitleAndAuthor(@RequestParam String title, @RequestParam String author){

        return ResponseEntity.ok(
                mapper.bookToResponse(
                        service.findByTitleAndAuthor(title, author)));
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody UpsertBookRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapper.bookToResponse(
                        service.create(
                                mapper.requestToBook(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable Long id, @RequestBody UpsertBookRequest request){



        return ResponseEntity.ok(
                mapper.bookToResponse(
                        service.update(mapper.requestToBook(id, request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(EntityNotFoundException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getLocalizedMessage()));
    }
}
