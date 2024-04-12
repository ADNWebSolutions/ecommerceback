package com.ADN.ecommerce.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class RolController {

    @GetMapping
    public ResponseEntity<> getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<>> getAll() {

    }

    @PostMapping
    public ResponseEntity<> create(@RequestBody  ) {

    }

    @PutMapping
    public ResponseEntity<> update(@RequestBody , @PathVariable Long id) {

    }

    @DeleteMapping
    public ResponseEntity<> delete(@PathVariable Long id) {

    }
}
