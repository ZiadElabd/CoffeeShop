package com.shop.CoffeeShop.repository;

import com.shop.CoffeeShop.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Cart_Id> {

    @Query("select  c.cart_id.productId AS productId,\n" +
            "        c.cart_id.userId AS userId,\n" +
            "        p.name AS name,\n" +
            "        p.image AS image,\n" +
            "        c.quantity AS quantity,\n" +
            "        c.size AS size,\n" +
            "        c.sugar AS sugar\n" +
            "from Cart c\n" +
            "    join Product p\n" +
            "        on c.cart_id.productId = p.productId\n" +
            "    join User u\n" +
            "        on u.userId = c.cart_id.userId\n" +
            "where c.cart_id.userId = ?1")
    List<CartItem> getUserCart(Long userId);
}
