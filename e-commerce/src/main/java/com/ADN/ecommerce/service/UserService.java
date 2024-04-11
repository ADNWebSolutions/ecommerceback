package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserService {
    
    public Optional<User> getById(Long id);

    public List<User> getAll();

    public User update(User newUser, Long id);

    public User save(User user);

    public boolean delete(Long id);

    public boolean existsById(Long id);
}
