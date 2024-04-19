package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.model.DTO.OfferDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter@Setter
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(name = "offer_item",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
    
    private LocalDate startDate;
    
    private LocalDate exprationDate;
    
    private String name;
    
    private String description;

    public Offer() {
    }

    public Offer(OfferDTO dto) {
        this.startDate = dto.getStartDate();
        this.exprationDate = dto.getExprationDate();
        this.name = dto.getName();
        this.description = dto.getDescription();
    }
    
    
}
