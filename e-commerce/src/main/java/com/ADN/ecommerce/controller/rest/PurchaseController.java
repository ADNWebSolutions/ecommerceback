package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.DTO.PurchaseDTO;
import com.ADN.ecommerce.model.entities.Purchase;
import com.ADN.ecommerce.service.PurchaseService;
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
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @Autowired
    private UserService userService;

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
    public ResponseEntity<Purchase> create(@RequestBody PurchaseDTO purchase,
            @RequestBody Long idUser,
            @RequestBody Long idReseller) {

        Purchase pur = new Purchase(purchase,
                //take user's id sended by bodyRequest and use it
                userService.getById(idUser).orElse(null),
                //same with the reseller id
                //aca se puede mejorar
                userService.getById(idReseller).orElse(null));
        service.save(pur);
        return new ResponseEntity(pur, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Purchase> update(@RequestBody PurchaseDTO purchase, @PathVariable("id") Long idPurchase,
            @RequestBody Long idUser,
            @RequestBody Long idReseller) {

        if (!service.existsById(idPurchase)) {
            return new ResponseEntity("that id Doesn't exists: " + idPurchase,
                    HttpStatus.BAD_REQUEST);
        } else {
            Purchase pur = service.update(
                    new Purchase(purchase,
                            userService.getById(idUser).orElse(null),
                            userService.getById(idReseller).orElse(null)),                    
                    idPurchase);
            
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
