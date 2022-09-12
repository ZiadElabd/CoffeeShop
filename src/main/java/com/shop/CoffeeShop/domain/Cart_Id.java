package com.shop.CoffeeShop.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Cart_Id implements Serializable {
    private long userId;
    private long productId;

    public Cart_Id(long userId, long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public Cart_Id() {

    }
}
