package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Purchase;
import com.ADN.ecommerce.repository.PurchaseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseImp implements PurchaseService {

    @Autowired
    private PurchaseRepository repo;

    @Override
    public Optional<Purchase> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Purchase> getAll() {
        return repo.findAll();
    }

    @Override
    public Purchase update(Purchase newPurchase, Long id) {
        Purchase oldPurchase = getById(id).orElseThrow(()
                -> new RuntimeException("The Purchase with the id: " + id + " couldn't be found"));
        oldPurchase.setDate(newPurchase.getDate());
        oldPurchase.setDetails(newPurchase.getDetails());
        oldPurchase.setReseller(newPurchase.getReseller());
        oldPurchase.calculateTotalAmount();
        oldPurchase.setUser(newPurchase.getUser());

        return save(oldPurchase);

    }

    @Override
    public Purchase save(Purchase purchase) {
        return repo.save(purchase);
    }

    @Override
    public boolean delete(Long id) {
        if (existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

}
