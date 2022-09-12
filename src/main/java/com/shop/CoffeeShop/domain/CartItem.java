package com.shop.CoffeeShop.domain;



public interface CartItem {

    public Long getProductId();
    public Long getUserId();
    public String getName();
    public String getImage();
    public int getQuantity();
    public int getSugar();
    public int getSize();

}
