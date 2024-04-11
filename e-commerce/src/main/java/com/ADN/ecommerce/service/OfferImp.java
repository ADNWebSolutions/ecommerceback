package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Offer;
import com.ADN.ecommerce.repository.OfferRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferImp implements OfferService {

    @Autowired
    private OfferRepository repo;

    @Override
    public Optional<Offer> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Offer> getAll() {
        return repo.findAll();
    }

    @Override
    public Offer update(Offer newOffer, Long id) {
        Offer oldOffer = getById(id).orElseThrow(()
                -> new RuntimeException("The offer with the id:" + id + " couldn't be found"));
        oldOffer.setDescription(newOffer.getDescription());
        oldOffer.setExprationDate(newOffer.getExprationDate());
        oldOffer.setItems(newOffer.getItems());
        oldOffer.setName(newOffer.getName());
        oldOffer.setStartDate(newOffer.getStartDate());

        return save(oldOffer);

    }

    @Override
    public Offer save(Offer offer) {
        return repo.save(offer);
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
