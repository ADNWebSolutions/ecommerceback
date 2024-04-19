package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.model.DTO.PurchaseDetailDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class PurchaseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;

    private float actualPrice;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public PurchaseDetail() {
    }

    public PurchaseDetail(PurchaseDetailDTO dto, Purchase purchase, Item item) {
        this.amount = dto.getAmount();
        this.actualPrice = dto.getActualPrice();
        this.purchase = purchase;
        this.item = item;
    }

    


}
