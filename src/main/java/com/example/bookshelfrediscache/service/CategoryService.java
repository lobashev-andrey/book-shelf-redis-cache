package com.example.bookshelfrediscache.service;

import com.example.bookshelfrediscache.model.Category;
import com.example.bookshelfrediscache.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Optional<Category> findByName(String name){

        return repository.findByName(name);
    }

    public Category createOrGet(String name) {

        return findByName(name).isEmpty() ?
                repository.save(new Category(name)) :
                findByName(name).get();
    }



}

