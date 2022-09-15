package com.shop.CoffeeShop.service;


import com.shop.CoffeeShop.Exceptions.NoSuchProductExistsException;
import com.shop.CoffeeShop.Exceptions.NoSuchUserExistsException;
import com.shop.CoffeeShop.Exceptions.ProductAlreadyExistsException;
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
        Product existingProduct = null;
        if(product.getProductId() != null)
            existingProduct = productRepository.findById(product.getProductId()).orElse(null);

        if (existingProduct == null){
            log.info("add new product {} to the database", product.getName());
            return productRepository.save(product);
        }
        else {
            throw new ProductAlreadyExistsException("Product is already exist");
        }
    }

    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId).get();
        if (product==null){
            throw new NoSuchUserExistsException("Product Not Found");
        }
        else {
            log.info(" remove product {} from database", product.getName());
            productRepository.delete(product);
        }
    }

    @Override
    public Product getProduct(String name) {
        Product existingProduct = productRepository.findByName(name);
        if (existingProduct == null){
            throw new NoSuchProductExistsException("Product Not Found");
        }
        else {
        log.info("Fetching product {}", name);
        return productRepository.findByName(name);
    }}

    public Product getProductById(Long productId) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct == null){
            throw new NoSuchProductExistsException("Product Not Found");
        }
        else {
        log.info("Fetching product with id {}", productId);
        return productRepository.findById(productId).get();
    }}

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
