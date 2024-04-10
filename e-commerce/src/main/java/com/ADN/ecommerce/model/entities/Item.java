package com.ADN.ecommerce.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Table
@Entity
@Getter@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    private String name;
    
    private String description;
    
    @ManyToOne
    private Category category;
    
    private int heigth;
    
    private int width;
    
    private int weight;
    
    private int depth;
    
    private int capacity;
    
    @ManyToOne
    private Color color;

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", description=" + description + ", heigth=" + heigth + ", width=" + width + ", weight=" + weight + ", depth=" + depth + ", capacity=" + capacity + '}';
    }
    
    
            
}
