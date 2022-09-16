package com.shop.CoffeeShop.api;


import com.shop.CoffeeShop.domain.Cart;
import com.shop.CoffeeShop.domain.CartItem;
import com.shop.CoffeeShop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @GetMapping("/get/{user_id}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable("user_id") Long userId){
        return ResponseEntity.ok().body(cartService.getUserCart(userId));
    }

    @PostMapping("add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart){
        return ResponseEntity.ok().body(cartService.add_to_cart(cart));
    }

    @DeleteMapping("delete/{userId}/{productId}")
    public void deleteCart(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId){
        cartService.remove_from_cart(userId, productId);
    }
}
