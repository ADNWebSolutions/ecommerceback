package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.PurchaseDetail;
import java.util.List;
import java.util.Optional;

public interface PurchaseDetailService {
    
    public Optional<PurchaseDetail> getById(Long id);

    public List<PurchaseDetail> getAll();

    public Optional<PurchaseDetail> update(PurchaseDetail oldDetail);

    public void save(PurchaseDetail detail);

    public boolean delete(Long id);

    public boolean existsById(Long id);
}
