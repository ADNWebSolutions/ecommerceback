package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.model.DTO.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Table
@Entity
@Getter@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String description;
    
    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public Category() {
    }

    public Category(CategoryDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
    }
        
}
