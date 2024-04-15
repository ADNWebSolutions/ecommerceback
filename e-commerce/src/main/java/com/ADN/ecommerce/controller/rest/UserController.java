package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.entities.Category;
import com.ADN.ecommerce.model.entities.User;
import com.ADN.ecommerce.service.UserService;
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
public class UserController {
    
    @Autowired
    private UserService service;

     @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            User user = service.getById(id).get();
            return new ResponseEntity(user, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> list = service.getAll();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User u = service.save(user);
        return new ResponseEntity(u, HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") Long id) {
        if(!service.existsById(id)){
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            User u = service.update(user, id);
            return new ResponseEntity(u, HttpStatus.OK);
        }      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        if(service.delete(id)){
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);
            
        }else{
             return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        }

    }
}
