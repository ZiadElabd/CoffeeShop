package com.shop.CoffeeShop.service;

import com.shop.CoffeeShop.Repository.CartRepository;
import com.shop.CoffeeShop.domain.Cart_Id;
import com.shop.CoffeeShop.domain.Product;
import com.shop.CoffeeShop.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Product add_to_cart(Product p) {
        log.info("adding product to db", p.getName());
        return cartRepository.save(p);
    }

    public void remove_from_cart(User user, Product p) {
        log.info("removing product from db ", p.getName());
        cartRepository.deleteById(new Cart_Id(user.getUserId(), p.getProductId()));
    }

    public List<Product> getAllProducts() {
        return cartRepository.findAll();
    }

}
