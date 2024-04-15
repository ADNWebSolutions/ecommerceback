package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.entities.Category;
import com.ADN.ecommerce.model.entities.Rol;
import com.ADN.ecommerce.service.RolService;
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
public class RolController {
    
    @Autowired
    private RolService service;

     @GetMapping("/{id}")
    public ResponseEntity<Rol> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Rol rol = service.getById(id).get();
            return new ResponseEntity(rol, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rol>> getAll() {
        List<Rol> list = service.getAll();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        Rol r = service.save(rol);
        return new ResponseEntity(r, HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> update(@RequestBody Rol rol, @PathVariable("id") Long id) {
        if(!service.existsById(id)){
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            Rol r = service.update(rol, id);
            return new ResponseEntity(r, HttpStatus.OK);
        }      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        if(service.delete(id)){
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);
            
        }else{
             return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        }

    }
}
