package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Purchase;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {
        
    public Optional<Purchase> getById(Long id);

    public List<Purchase> getAll();

    public Purchase update(Purchase newPurchase, Long id);

    public Purchase save(Purchase purchase);

    public boolean delete(Long id);

    public boolean existsById(Long id);

}
