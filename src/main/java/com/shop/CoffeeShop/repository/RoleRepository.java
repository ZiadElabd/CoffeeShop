package com.shop.CoffeeShop.repository;


import com.shop.CoffeeShop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}