package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private double currentMoneyProvided;
    private String slotSelection;
    private Boolean isFinished;
    private List<Product> productsToPurchase;

    public User() {
        this.currentMoneyProvided = 0.00;
        this.isFinished = false;
        this.productsToPurchase = new ArrayList<>();
    }

    //Methods
    public double addMoney(int bill){
        if (bill == 1 || bill == 2 || bill == 5 || bill == 10) {
            return currentMoneyProvided += bill;
        } else {
            return currentMoneyProvided;
        }
    }

    public double dispenseChange() {
        return currentMoneyProvided;
    }

    public List<Product> addProductToPurchaseList(Product p) {
        //Add product to the user's purchase list
        if(p==null) {
            return productsToPurchase;
        }
        getProductsToPurchase().add(p);
        //update stock count to reflect that one has been purchased
        p.setStockCount(p.getStockCount() - 1);
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
