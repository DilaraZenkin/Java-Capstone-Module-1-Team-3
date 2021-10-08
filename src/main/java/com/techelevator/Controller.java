package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Machine vendingMachine;
    private UserInterface userInterface;
    private User user;

    public Controller(Machine vendingMachine, UserInterface userInterface, User user) {
        this.vendingMachine = vendingMachine;
        this.userInterface = userInterface;
        this.user = user;
        startProgram();
    }

    public void startProgram() {

        Boolean isUserPresent = true;

        while (isUserPresent) {
            userInterface.displayMainMenu();
            String userSelection = userInterface.getUserInput();
            switch (userSelection) {
                case "1":
                    //(1) Display Vending Machine Items
                    //System.out.println("You selected #1");
                    vendingMachine.displayProducts();
                    System.out.println();
                    //userInterface.displayMainMenu();
                    break;
                case "2":
                    //(2) Purchase
                    //System.out.println("You selected #2");
                    purchase();
                    break;
                case "3":
                    //(3) Exit
                    //System.out.println("You selected #3");
                    isUserPresent = false;
                    break;
                default:
                    System.out.println("Please choose a number between 1 and 3");
                    break;
            }

        }


    }

    public void displayVendingMachineItems(){
        vendingMachine.displayProducts();
    }

    public void purchase(){
        Boolean isUserPresent = true;

        while (isUserPresent) {
            userInterface.displayPurchaseMenu(user.getCurrentMoneyProvided());
            String purchaseMenuUserSelection = userInterface.getUserInput();
            if (purchaseMenuUserSelection.equals("1")) {
                user.addMoney(userInterface.feedMoney());
            } else if (purchaseMenuUserSelection.equals("2")) {
                String slotChoice = userInterface.selectProduct();
                //System.out.println("You selected " + slotChoice);
                if (vendingMachine.isSlotValid(slotChoice)){
                    //System.out.println("That is a valid choice");
                    //enter product into List
                    user.addProductToPurchaseList(vendingMachine.getProduct(slotChoice));
                    List<Product> productsToPurchase = new ArrayList<>();
                    productsToPurchase = user.getProductsToPurchase();
                    for (Product item : productsToPurchase) {
                        System.out.println(item.getName());
                    }
                    //System.out.println(user.getProductsToPurchase());
                } else {
                    //System.out.println("This is not a valid choice");
                }
                //check if slot is valid
                    //if slot is valid, enter product into List
                    //else prompt user for another choice

            } else if (purchaseMenuUserSelection.equals("3")) {
                userInterface.finishTransaction();
                isUserPresent = false;
            } else {
                System.out.println("Please enter a selection between 1 and 3");
            }
            //userInterface.getUserInput();
        }
        return;

    }

    public void exit() {

    }

}
