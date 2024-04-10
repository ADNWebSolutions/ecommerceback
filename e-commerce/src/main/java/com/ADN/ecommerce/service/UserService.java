package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserService {
    
    public Optional<User> getById(Long id);

    public List<User> getAll();

    public Optional<User> update(User oldUser);

    public void save(User user);

    public boolean delete(Long id);

    public boolean existsById(Long id);
}
