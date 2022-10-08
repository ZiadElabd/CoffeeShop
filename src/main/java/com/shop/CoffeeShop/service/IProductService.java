package com.shop.CoffeeShop.service;

import com.shop.CoffeeShop.domain.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);
    Product getProduct(String name);
    Product getProductById(Long productId);

    List<Product> getAllProducts();

    void deleteProduct(Long productId);

}
