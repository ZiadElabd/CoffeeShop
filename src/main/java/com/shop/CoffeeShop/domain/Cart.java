package com.shop.CoffeeShop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {
    @EmbeddedId
    private Cart_Id cart_id;
    private int size;
    private int sugar;
}
