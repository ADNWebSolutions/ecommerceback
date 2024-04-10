package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public Optional<Category> getById(Long id);
    
    public List<Category> getAll();
    
    public Optional<Category> update(Category oldCategory);
    
    public void save(Category category);
    
    public boolean delete(Long id);
    
    public boolean existsById(Long id);
}
