package com.shop.CoffeeShop.service;


import com.shop.CoffeeShop.domain.User;
import com.shop.CoffeeShop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        // encode password before saving
        return userRepository.save(user);
    }

    public User getUser(String email) {
        log.info("Fetching user {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            log.error("user if not found in database, register a new one");
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
