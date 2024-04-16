package com.ADN.ecommerce.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDetailDTO {

    private Long item_id ;

    private int amount;

    private float actualPrice;
}
