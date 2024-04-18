package com.ADN.ecommerce.model.state;

import com.ADN.ecommerce.model.entities.Purchase;

public interface PurchaseState {

    public void toCreate(Purchase purchase);

    public void toUpdate(Purchase purchase);

    public void toCancel(Purchase purchase);

    public void toComplete(Purchase purchase);
}
