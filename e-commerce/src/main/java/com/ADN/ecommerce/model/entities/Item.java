package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.model.DTO.ItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int heigth;

    private int width;

    private int weight;

    private int depth;

    private int capacity;

    private int actualStock;

    private int minStock;
    
    private float price;
    
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToMany(mappedBy = "items")
    private List<Offer> offers;

    @OneToMany(mappedBy = "item")
    private List<PurchaseDetail> details;

    public Item() {
    }

    public Item(ItemDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.heigth = dto.getHeigth();
        this.width = dto.getWidth();
        this.weight = dto.getWeight();
        this.depth = dto.getDepth();
        this.capacity = dto.getCapacity();
        this.actualStock = dto.getActualStock();
        this.minStock = dto.getMinStock();
        this.price = dto.getPrice();
        this.imageURL = dto.getImageURL();
    }
    
    

}
