package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.entities.Category;
import com.ADN.ecommerce.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Category category = service.getById(id).get();
            return new ResponseEntity(category, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> list = service.getAll();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category cat = service.save(category);
        return new ResponseEntity(cat, HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable("id") Long id) {
        if(!service.existsById(id)){
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Category cat = service.update(category, id);
            return new ResponseEntity(cat, HttpStatus.OK);
        }      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        if(service.delete(id)){
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);
            
        }else{
             return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        }

    }

}
