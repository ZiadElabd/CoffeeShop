package com.shop.CoffeeShop.api;

import com.shop.CoffeeShop.domain.User;
import com.shop.CoffeeShop.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

}