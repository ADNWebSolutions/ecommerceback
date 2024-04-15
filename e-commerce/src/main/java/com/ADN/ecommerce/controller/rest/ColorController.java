package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.entities.Color;
import com.ADN.ecommerce.service.ColorService;
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
@RequestMapping()
public class ColorController {
    
    @Autowired
    private ColorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Color> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Color color = service.getById(id).get();
            return new ResponseEntity(color, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Color>> getAll() {
        List<Color> list = service.getAll();        
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Color> create(@RequestBody Color color) {
        Color col = service.save(color);
        return new ResponseEntity(col, HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Color> update(@RequestBody Color color, @PathVariable("id") Long id) {
        if(!service.existsById(id)){
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Color col = service.update(color, id);
            return new ResponseEntity(col, HttpStatus.OK);
        }      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Color> delete(@PathVariable Long id) {
        if(service.delete(id)){
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);
            
        }else{
             return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        }
    }
}
