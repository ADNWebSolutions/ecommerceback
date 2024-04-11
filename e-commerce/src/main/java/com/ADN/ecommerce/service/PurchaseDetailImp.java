package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.PurchaseDetail;
import com.ADN.ecommerce.repository.PurchaseDetailRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailImp implements PurchaseDetailService {
    
    @Autowired
    private PurchaseDetailRepository repo;
    
    @Override
    public Optional<PurchaseDetail> getById(Long id) {
        return repo.findById(id);
    }
    
    @Override
    public List<PurchaseDetail> getAll() {
        return repo.findAll();
    }
    
    @Override
    public PurchaseDetail update(PurchaseDetail newDetail, Long id) {
        PurchaseDetail oldDetail = getById(id).orElseThrow(()
                -> new RuntimeException("The detail with the id: " + id + " couldn't be found"));
        
        oldDetail.setActualPrice(newDetail.getActualPrice());
        oldDetail.setAmount(newDetail.getAmount());
        oldDetail.setItem(newDetail.getItem());
        oldDetail.setPurchase(newDetail.getPurchase());
        
        return save(oldDetail);
    }
    
    @Override
    public PurchaseDetail save(PurchaseDetail detail) {
        return repo.save(detail);
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
