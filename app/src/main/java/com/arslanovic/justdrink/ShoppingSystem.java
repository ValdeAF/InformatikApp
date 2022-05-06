package com.arslanovic.justdrink;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingSystem implements Serializable {
    //Private list containing all current products
    private List<Product> productList = new ArrayList<>();
    //Private list containing the products in the basket
    private List<Product> basket = new ArrayList<>();

    public ShoppingSystem(){

    }
    public void createProduct(String Name, int Code, int Price){
        productList.add(new Product(Name, Code, Price));
    }

    public void addToBasket(Product product) {
        basket.add(product);
    }

    public int getBasketValue(){
        int totalPrice = 0;
        for(int i = 0; i < basket.size(); i++){
            totalPrice += basket.get(i).getPrice();
        }
        return totalPrice;
    }

    public String getBasketSummary(){
        String res = "Beskrivelse          Pris";
        for(int i = 0; i < basket.size(); i++){
            res += basket.get(i).getName() + "          " + basket.get(i).getPrice();
        }
        return res;
    }

    private int numberOfItems(){
        /*for(int i = 0; i < basket.size(); i++){
            if(productList.get(i).getCode() == Code){
                return productList.get(i);
            }
        }*/
        return 1;
    }

    public Product findProduct(int Code){
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getCode() == Code){
                return productList.get(i);
            }
        }
        return null;
    }
}
