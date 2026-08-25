package com.example.adidas;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String description;
    private String price;
    private int imageResource;

    public Product(String name, String description, String price, int imageResource) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public int getImageResource() { return imageResource; }
}
