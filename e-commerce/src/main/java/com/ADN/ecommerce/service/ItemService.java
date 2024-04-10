package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Color;
import com.ADN.ecommerce.model.entities.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    
    public Optional<Item> getById(Long id);
    
    public List<Item> getAll();
    
    public Optional<Item> update(Item oldItem);
    
    public void save(Item item);
    
    public boolean delete(Long id);
    
    public boolean existsById(Long id);

}
