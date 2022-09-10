package com.shop.CoffeeShop;

import com.shop.CoffeeShop.domain.User;
import com.shop.CoffeeShop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			User user = userService.getUser("bgfbfgbgf@gfbgfb");
			log.info(user.toString());


			user = userService.getUser("bgfbfgbgf@gfbgfb", "encodedpassword");

			log.info(user.toString());

		};
	}

}
