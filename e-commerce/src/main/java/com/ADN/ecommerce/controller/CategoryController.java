package com.ADN.ecommerce.controller;

import com.ADN.ecommerce.model.entities.Category;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CategoryController {

    @GetMapping
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {

    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {

    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id) {

    }

    @DeleteMapping
    public ResponseEntity<Category> delete(@PathVariable Long id) {

    }

}
