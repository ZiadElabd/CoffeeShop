package com.shop.CoffeeShop.service;

import com.shop.CoffeeShop.domain.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);
    void deleteProduct(Long productId);
    Product getProduct(String name);
    List<Product> getAllProducts();

}
