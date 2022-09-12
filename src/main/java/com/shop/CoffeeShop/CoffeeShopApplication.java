package com.shop.CoffeeShop;

import com.shop.CoffeeShop.domain.*;
import com.shop.CoffeeShop.repository.CartRepository;
import com.shop.CoffeeShop.service.ProductService;
import com.shop.CoffeeShop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserService userService, ProductService productService, CartRepository cartRepository) {
		return args -> {
//			User user = userService.getUser("bgfbfgbgf@gfbgfb");
//			log.info(user.toString());
//
//
//			user = userService.getUser("bgfbfgbgf@gfbgfb", "encodedpassword");
//
//			log.info(user.toString());
//
//
//			List<Product> products = productService.getAllProducts();
//
//			products.forEach(System.out::println);
//
//
//			productService.deleteProduct(1L);
//
//			products = productService.getAllProducts();
//
//			products.forEach(System.out::println);

//			List<Cart> cart = cartRepository.findAll();
//
//			cart.forEach(System.out::println);

//			List<CartItem> cart_item = cartRepository.getUserCart(1L);
//
//			cart_item.forEach(System.out::println);
//			for (CartItem i : cart_item){
//				System.out.println(i.getName() + "**" + i.getProductId() + "**" + i.getSugar());
//			}

		};
	}

}
