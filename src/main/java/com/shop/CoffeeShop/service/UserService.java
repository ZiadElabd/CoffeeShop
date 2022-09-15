package com.shop.CoffeeShop.service;


import com.shop.CoffeeShop.Exceptions.NoSuchUserExistsException;
import com.shop.CoffeeShop.Exceptions.UserAlreadyExistsException;
import com.shop.CoffeeShop.domain.Role;
import com.shop.CoffeeShop.domain.User;
import com.shop.CoffeeShop.repository.RoleRepository;
import com.shop.CoffeeShop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;


    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }



    @Override
    public User saveUser(User user) {

        User existingUser = null;

        if (user.getUserId() != null)
            existingUser = userRepository.findById(user.getUserId()).orElse(null);

        if (existingUser == null){
            log.info("Saving new user {} to the database", user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User res =  userRepository.save(user);
            this.addRoleToUser(user.getEmail(), "ROLE_USER");
            return res;
        }
        else throw new UserAlreadyExistsException("Customer already exists!!");
    }

    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to user {}", roleName, email);
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }

    public User getUser(String email) {
        User existingUser
                = userRepository.findByEmail(email);
        if(existingUser==null){
            throw new NoSuchUserExistsException("User Not Found");
        }
        else {
        log.info("Fetching user {}", email);
        return userRepository.findByEmail(email);
    }}

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
