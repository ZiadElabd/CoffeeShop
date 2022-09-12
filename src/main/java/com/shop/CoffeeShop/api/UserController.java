package com.shop.CoffeeShop.api;

import com.shop.CoffeeShop.domain.User;
import com.shop.CoffeeShop.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }


    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody User form){
        User user = userService.getUser(form.getEmail(), form.getPassword());
        System.out.println(form);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(user);
    }
}