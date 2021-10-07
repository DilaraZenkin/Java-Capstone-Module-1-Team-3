package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private double currentMoneyProvided;
    private String slotSelection;
    private Boolean isFinished;
    private List<Product> productsToPurchase;

    public User() {
        this.currentMoneyProvided =0.00;
        this.isFinished = false;
        this.productsToPurchase = new ArrayList<>();
    }
    //Methods
   // addMoney(int bill)
    public double addMoney(int bill) {
        return currentMoneyProvided += bill;
    }
    // dispenseChange()

    public double dispenseChange() {
        return currentMoneyProvided;
    }

    // addProductToPurchaseList()

    public List<Product> addProductToPurchaseList(Product p) {
        getProductsToPurchase().add(p);
        return productsToPurchase;
    }


    //Getter-Setter
    public double getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided(double currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public String getSlotSelection() {
        return slotSelection;
    }

    public void setSlotSelection(String slotSelection) {
        this.slotSelection = slotSelection;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public List<Product> getProductsToPurchase() {
        return productsToPurchase;
    }

    public void setProductsToPurchase(List<Product> productsToPurchase) {
        this.productsToPurchase = productsToPurchase;
    }
}
