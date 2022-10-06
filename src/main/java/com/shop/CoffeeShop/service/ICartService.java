package com.shop.CoffeeShop.service;

import com.shop.CoffeeShop.domain.Cart;
import com.shop.CoffeeShop.domain.CartItem;

import java.util.List;

public interface ICartService {

    Cart add_to_cart(Cart cart);
    void remove_from_cart(Long userId, Long productId);
    List<CartItem> getUserCart(Long userId);
}
