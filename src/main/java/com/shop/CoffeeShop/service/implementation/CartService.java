package com.shop.CoffeeShop.service.implementation;

import com.shop.CoffeeShop.domain.*;
import com.shop.CoffeeShop.repository.CartRepository;
import com.shop.CoffeeShop.service.ICartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRepository;

    public Cart add_to_cart(Cart cart) {
        log.info("adding item to cart {}", cart.toString());
        return cartRepository.save(cart);
    }

    public void remove_from_cart(Long userId, Long productId) {
        log.info("removing product from db ");
        cartRepository.deleteById(new Cart_Id(userId, productId));
    }

    public List<CartItem> getUserCart(Long userId){
        return cartRepository.getUserCart(userId);
    }

}
