package com.shop.CoffeeShop.service;

import com.shop.CoffeeShop.domain.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    User getUser(String userName);

    User getUser(String email, String password);

    List<User> getAllUsers();
}
