package com.ADN.ecommerce.repository;

import com.ADN.ecommerce.model.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}