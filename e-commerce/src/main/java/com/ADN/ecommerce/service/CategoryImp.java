package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Category;
import com.ADN.ecommerce.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryImp implements CategoryService {
    
    @Autowired
    private CategoryRepository repo;
    
    @Override
    public Optional<Category> getById(Long id) {
        return repo.findById(id);
    }
    
    @Override
    public List<Category> getAll() {
        return repo.findAll();        
    }
    
    @Override
    public Category update(Category newCategory, Long id) {
        Category oldCategory = getById(id).orElseThrow(()
                -> new RuntimeException("Category didn't find with the id: " + id ));
        oldCategory.setDescription(newCategory.getDescription());
        oldCategory.setName(newCategory.getName());
        repo.save(oldCategory);
        
        return newCategory;
        
    }
    
    @Override
    public Category save(Category category) {
       return repo.save(category);
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
