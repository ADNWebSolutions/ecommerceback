package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Color;
import java.util.List;
import java.util.Optional;

public interface ColorService {
    
    public Optional<Color> getById(Long id);
    
    public List<Color> getAll();
    
    public Color update(Color oldColor, Long id);
    
    public Color save(Color color);
    
    public boolean delete(Long id);
    
    public boolean existsById(Long id);
}
