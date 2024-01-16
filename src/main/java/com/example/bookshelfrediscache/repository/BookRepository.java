package com.example.bookshelfrediscache.repository;

import com.example.bookshelfrediscache.model.Book;
import com.example.bookshelfrediscache.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory(Category category);

    Optional<Book> findByTitleAndAuthor(String title, String author);




}
