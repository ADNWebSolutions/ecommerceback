package com.ADN.ecommerce.model.entities;

import com.ADN.ecommerce.model.DTO.PurchaseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private float totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reseller_id")    
    private User reseller;    

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> details;

    public void calculateTotalAmount() {
        totalAmount = 0;
        details.forEach(detail -> totalAmount
                += detail.getAmount());
    }

    public Purchase() {
    }

    public Purchase(PurchaseDTO dto, User user, User reseller) {
        this.date = dto.getDate();
        this.totalAmount = dto.getTotalAmount();
        this.user = user;
        this.reseller = reseller;
    }
    
    
    
}
