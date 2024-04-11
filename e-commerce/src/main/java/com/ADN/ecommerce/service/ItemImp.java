package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Item;
import com.ADN.ecommerce.repository.ItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemImp implements ItemService {

    @Autowired
    private ItemRepository repo;

    @Override
    public Optional<Item> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Item> getAll() {
        return repo.findAll();
    }

    @Override
    public Item update(Item newItem, Long id) {
        Item oldItem = getById(id).orElseThrow(()
                -> new RuntimeException("The item with the id: " + id + "couldn't be found"));
        oldItem.setActualStock(newItem.getActualStock());
        oldItem.setCapacity(newItem.getCapacity());
        oldItem.setCategory(newItem.getCategory());
        oldItem.setColor(newItem.getColor());
        oldItem.setDepth(newItem.getDepth());
        oldItem.setDescription(newItem.getDescription());
        oldItem.setHeigth(newItem.getHeigth());
        oldItem.setMinStock(newItem.getMinStock());
        oldItem.setName(newItem.getName());
        oldItem.setWeight(newItem.getWeight());
        oldItem.setWidth(newItem.getWidth());

        return save(oldItem);
    }

    @Override
    public Item save(Item item) {
        return repo.save(item);
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
