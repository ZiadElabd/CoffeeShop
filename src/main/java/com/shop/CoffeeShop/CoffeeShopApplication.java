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




//			Product product1 = new Product(1L,
//					"Latte",
//					0,
//					10,
//					15,
//					20,
//					"https://user-images.githubusercontent.com/76598011/189742026-ae0e2abc-9cad-4414-84c0-a0e04c458d8e.png",
//					"https://user-images.githubusercontent.com/76598011/189876661-f8bae1bf-eb08-4c86-bc40-6a8856ef84ee.svg");
//
//			Product product2 = new Product(2L,
//					"Macciato",
//					0,
//					10,
//					15,
//					20,
//					"https://user-images.githubusercontent.com/76598011/189742029-2a01aae9-7a38-48a5-8014-f8d0d6f161b7.png",
//					"https://user-images.githubusercontent.com/76598011/189876667-75485b32-96c3-4f7c-8135-4a7014efe650.svg");
//
//
//			Product product3 = new Product(3L,
//					"Mocha",
//					0,
//					10,
//					15,
//					20,
//					"https://user-images.githubusercontent.com/76598011/189742030-5eb6eded-5862-401a-ba69-8a3a62191d14.png",
//					"https://user-images.githubusercontent.com/76598011/189876669-9f981561-87c1-442d-b096-47a30a4524d6.svg");
//
//			Product product4 = new Product(4L,
//					"Cappuccino",
//					0,
//					10,
//					15,
//					20,
//					"https://user-images.githubusercontent.com/76598011/189742034-8292e2c1-2010-4f5d-86b4-4fc629be622e.png",
//					"https://user-images.githubusercontent.com/76598011/189876670-7ab081b4-36c8-49ff-a384-8fa007dbc14a.svg");
//
//			Product product5 = new Product(5L,
//					"Espresso",
//					0,
//					10,
//					15,
//					20,
//					"https://user-images.githubusercontent.com/76598011/189742036-7e2508ea-5d9e-4cbe-a6e7-2d8bfd59b481.png",
//					"https://user-images.githubusercontent.com/76598011/189876672-c256b619-6acf-4c20-bfc1-af0aedfb43a8.svg");
//
//			productService.addProduct(product1);
//			productService.addProduct(product2);
//			productService.addProduct(product3);
//			productService.addProduct(product4);
//			productService.addProduct(product5);



		};
	}

}
