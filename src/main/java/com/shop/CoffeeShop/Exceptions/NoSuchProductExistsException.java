package com.shop.CoffeeShop.Exceptions;

public class NoSuchProductExistsException extends NoSuchUserExistsException{

    public NoSuchProductExistsException() {
    }

    public NoSuchProductExistsException(String msg) {
        super(msg);
    }
}
