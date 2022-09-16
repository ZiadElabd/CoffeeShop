package com.shop.CoffeeShop.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
public class Cart_Id implements Serializable {
    private Long userId;
    private Long productId;

    public Cart_Id(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
