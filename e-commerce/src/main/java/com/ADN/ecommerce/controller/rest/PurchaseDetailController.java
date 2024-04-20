package com.ADN.ecommerce.controller.rest;

import com.ADN.ecommerce.model.DTO.PurchaseDetailDTO;
import com.ADN.ecommerce.model.entities.PurchaseDetail;
import com.ADN.ecommerce.service.ItemService;
import com.ADN.ecommerce.service.PurchaseDetailService;
import com.ADN.ecommerce.service.PurchaseService;
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
@RequestMapping("/purchase_detail")
public class PurchaseDetailController {

    @Autowired
    private PurchaseDetailService service;
    
    @Autowired
    private PurchaseService servicePurchase;
    
    @Autowired
    private ItemService serviceItem;
    
     @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetail> getById(@PathVariable("id") Long id) {

        if (!service.existsById(id)) {
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            PurchaseDetail detail = service.getById(id).get();
            return new ResponseEntity(detail, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PurchaseDetail>> getAll() {
        List<PurchaseDetail> list = service.getAll();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PurchaseDetail> create(@RequestBody PurchaseDetailDTO detail, @RequestBody Long idPurchase, @RequestBody Long idItem) {
        
        PurchaseDetail det = new PurchaseDetail(detail,                 
                servicePurchase.getById(idPurchase).orElse(null),
                serviceItem.getById(idItem).orElse(null));
        
                service.save(det);
        return new ResponseEntity(det, HttpStatus.OK);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PurchaseDetail> update(@RequestBody PurchaseDetailDTO detail, @PathVariable("id") Long id, @RequestBody Long idPurchase, @RequestBody Long idItem) {
        if(!service.existsById(id)){
            return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        } else {
            PurchaseDetail det = new PurchaseDetail(detail,                 
                servicePurchase.getById(idPurchase).orElse(null),
                serviceItem.getById(idItem).orElse(null));
        
                    
                    service.update(det, id);
            return new ResponseEntity(det, HttpStatus.OK);
        }      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PurchaseDetail> delete(@PathVariable Long id) {
        if(service.delete(id)){
            return new ResponseEntity("Deleted Completed", HttpStatus.OK);
            
        }else{
             return new ResponseEntity("that id Doesn't exists: " + id,
                     HttpStatus.BAD_REQUEST);
        }

    }
}
