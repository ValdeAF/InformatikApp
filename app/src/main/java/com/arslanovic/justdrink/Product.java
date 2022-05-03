package com.arslanovic.justdrink;

public class Product {
    private String Name;

    private int Code;

    private int Price;

    public Product(String Name, int Code, int Price){
        this.Name = Name;
        this.Code = Code;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public int getCode() {
        return Code;
    }

    public int getPrice() {
        return Price;
    }
}
