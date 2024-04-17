package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.entities.Item;
import com.ADN.ecommerce.model.entities.Offer;
import com.ADN.ecommerce.service.OfferService;
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
@RequestMapping("/offer")
public class OfferController {
    
    @Autowired
    private OfferService service;

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                    HttpStatus.BAD_REQUEST);
        } else {
            Offer offer = service.getById(id).get();
            return new ResponseEntity(offer, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Offer>> getAll() {
        List<Offer> list = service.getAll();

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        Offer it = service.save(offer);
        return new ResponseEntity(it, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Offer> update(@RequestBody Offer offer, @PathVariable("id") Long id) {
        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                    HttpStatus.BAD_REQUEST);
        } else {
            Offer off = service.update(offer, id);
            return new ResponseEntity(off, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Offer> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);

        } else {
            return new ResponseEntity("that id Doesn't exists: " + id,
                    HttpStatus.BAD_REQUEST);
        }
    }
}
