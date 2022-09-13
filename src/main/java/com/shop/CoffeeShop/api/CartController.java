package com.shop.CoffeeShop.api;


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

}
