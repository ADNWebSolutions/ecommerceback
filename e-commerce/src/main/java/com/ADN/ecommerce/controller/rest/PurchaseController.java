package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.entities.Category;
import com.ADN.ecommerce.model.entities.Purchase;
import com.ADN.ecommerce.service.PurchaseService;
import java.util.List;
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
public class PurchaseController {
    
    private PurchaseService service;

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                    HttpStatus.BAD_REQUEST);
        } else {
            Purchase purchase = service.getById(id).get();
            return new ResponseEntity(purchase, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Purchase>> getAll() {
        List<Purchase> list = service.getAll();

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Purchase> create(@RequestBody Purchase purchase) {
        Purchase pur = service.save(purchase);
        return new ResponseEntity(pur, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Purchase> update(@RequestBody Purchase purchase, @PathVariable("id") Long id) {
        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                    HttpStatus.BAD_REQUEST);
        } else {
            Purchase pur = service.update(purchase, id);
            return new ResponseEntity(pur, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Purchase> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);

        } else {
            return new ResponseEntity("that id Doesn't exists: " + id,
                    HttpStatus.BAD_REQUEST);
        }

    }
}
