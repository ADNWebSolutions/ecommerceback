package com.ADN.ecommerce.controller.rest;


import com.ADN.ecommerce.model.entities.Item;
import com.ADN.ecommerce.service.ItemService;
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
public class ItemController {
    
    @Autowired
    private ItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Item item = service.getById(id).get();
            return new ResponseEntity(item, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAll() {
        List<Item> list = service.getAll();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        Item it = service.save(item);
        return new ResponseEntity(it, HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable("id") Long id) {
        if(!service.existsById(id)){
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Item it = service.update(item, id);
            return new ResponseEntity(it, HttpStatus.OK);
        }      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item> delete(@PathVariable Long id) {
        if(service.delete(id)){
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);
            
        }else{
             return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        }
    }
}
