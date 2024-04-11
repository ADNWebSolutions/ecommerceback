package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Rol;
import com.ADN.ecommerce.repository.RolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolImp implements RolService {

    @Autowired
    private RolRepository repo;

    @Override
    public Optional<Rol> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Rol> getAll() {
        return repo.findAll();
    }

    @Override
    public Rol update(Rol newRol, Long id) {
        Rol oldRol = getById(id).orElseThrow(() ->
                new RuntimeException("The Rol with the id: "+ id + " couldn't be found"));
        oldRol.setName(newRol.getName());
        oldRol.setUsers(newRol.getUsers());        
        
        return save(oldRol);
    }

    @Override
    public Rol save(Rol rol) {
        return repo.save(rol);
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
