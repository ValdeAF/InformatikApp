package com.arslanovic.justdrink;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    //Private list containing the products
    private List<String> Products = new ArrayList<String>();

    //Constructor
    public Basket(){

    }

    //Getter
    public List<String> getProducts(){
        return Products;
    }
    //Setter
    public void addProducts(String input){
        Products.add(input);
    }
}
