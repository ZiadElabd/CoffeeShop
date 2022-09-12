package com.shop.CoffeeShop.Repository;

import com.shop.CoffeeShop.domain.Cart;
import com.shop.CoffeeShop.domain.Cart_Id;
import com.shop.CoffeeShop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Product, Cart_Id> {
}
