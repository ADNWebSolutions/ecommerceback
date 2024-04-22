package com.ADN.ecommerce.model.DTO;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDTO {

    private LocalDate startDate;
    
    private LocalDate exprationDate;
    
    private String name;
    
    private String description;
    
    private double discountRate;
}
