package com.techelevator;

public class Product {
    private String name;
    private String category;
    private double price;
    private int stockCount;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockCount = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
