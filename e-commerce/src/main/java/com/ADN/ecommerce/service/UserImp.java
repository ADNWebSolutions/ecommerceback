package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.User;
import com.ADN.ecommerce.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImp implements UserService {
    
    @Autowired
    private UserRepository repo;
    
    @Override
    public Optional<User> getById(Long id) {
        return repo.findById(id);
    }
    
    @Override
    public List<User> getAll() {
        return repo.findAll();
    }
    
    @Override
    public User update(User newUser, Long id) {
        User oldUser = getById(id).orElseThrow(()
                -> new RuntimeException("The user with the id: " + id + " couldn't be found"));
        oldUser.setEmail(newUser.getEmail());
        oldUser.setName(newUser.getName());
        oldUser.setPassword(newUser.getPassword());
        
        return save(oldUser);
    }
    
    @Override
    public User save(User user) {
        return repo.save(user);
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
