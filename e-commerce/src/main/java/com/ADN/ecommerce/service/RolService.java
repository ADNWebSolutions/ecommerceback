package com.ADN.ecommerce.service;

import com.ADN.ecommerce.model.entities.Rol;
import java.util.List;
import java.util.Optional;

public interface RolService {
    
    public Optional<Rol> getById(Long id);

    public List<Rol> getAll();

    public Optional<Rol> update(Rol oldRol);

    public void save(Rol rol);

    public boolean delete(Long id);

    public boolean existsById(Long id);

}
