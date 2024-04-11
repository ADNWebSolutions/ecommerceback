package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Color;
import com.ADN.ecommerce.repository.ColorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorImp implements ColorService {

    @Autowired
    private ColorRepository repo;

    @Override
    public Optional<Color> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Color> getAll() {
        return repo.findAll();
    }

    @Override
    public Color update(Color newColor, Long id) {
        Color oldColor = getById(id).orElseThrow(()
                -> new RuntimeException("The color with that id couldn't be found"));
        oldColor.setName(newColor.getName());

        return save(oldColor);
    }

    @Override
    public Color save(Color color) {
        return repo.save(color);
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
