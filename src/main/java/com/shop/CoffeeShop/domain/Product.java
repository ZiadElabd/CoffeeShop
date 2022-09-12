package com.shop.CoffeeShop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Product")

public class Product {
    @Id
    @GeneratedValue
    private long productId;
    private String name;
    private int quantity;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int small_price;
    private int medium_price;
    private int large_price;
    private String image;
}