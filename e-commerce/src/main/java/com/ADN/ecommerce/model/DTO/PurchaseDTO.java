package com.ADN.ecommerce.model.DTO;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDTO {

    private LocalDate date;

    private float totalAmount;
    
    private Long idUser;
    
    private Long idReller;
}
