package com.ADN.ecommerce.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ItemDTO {

    private String name;
    
    private String description;
    
    private int heigth;

    private int width;

    private int weight;

    private int depth;

    private int capacity;

    private int actualStock;

    private int minStock;

}
