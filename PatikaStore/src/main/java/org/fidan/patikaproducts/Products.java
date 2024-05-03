package org.fidan.patikaproducts;

import java.util.Map;
import java.util.TreeMap;

public abstract class Products {
    public static int commonID=0;
    private int productID;
    private String name;
    private Brand brand;
    private String category;
    private double price;
    private int discount;
    


    public Products(String name, Brand brand, String category, double price2, int discount) {
        this.productID = ++commonID;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price2;
        this.discount = discount;
    }



    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
   
    
    

    public void buy(){

    }
    
    public static void remove(Products products){

    }

    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    

    
}
