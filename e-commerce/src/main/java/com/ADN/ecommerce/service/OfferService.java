package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Offer;
import java.util.List;
import java.util.Optional;

public interface OfferService {

    public Optional<Offer> getById(Long id);

    public List<Offer> getAll();

    public Optional<Offer> update(Offer oldOffer);

    public void save(Offer offer);

    public boolean delete(Long id);

    public boolean existsById(Long id);
}
