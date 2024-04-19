package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.model.DTO.ColorDTO;
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
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy =  "color")
    private List<Item> items;

    public Color() {
    }

    public Color(ColorDTO dto) {
        this.name = dto.getName();
    }
    
    
}
