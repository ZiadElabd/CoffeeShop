package com.shop.CoffeeShop.service;


import com.shop.CoffeeShop.domain.Product;
import com.shop.CoffeeShop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        log.info("add new product {} to the database", product.getName());
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId).get();
        log.info(" remove product {} from database", product.getName());
        productRepository.delete(product);
    }

    @Override
    public Product getProduct(String name) {
        log.info("Fetching product {}", name);
        return productRepository.findByName(name);
    }

    public Product getProductById(Long productId) {
        log.info("Fetching product with id {}", productId);
        return productRepository.findById(productId).get();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
