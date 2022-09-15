package com.shop.CoffeeShop.Exceptions;

public class ProductAlreadyExistsException extends UserAlreadyExistsException{
    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String msg) {
        super(msg);
    }
}
