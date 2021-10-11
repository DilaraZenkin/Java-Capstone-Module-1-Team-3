package com.techelevator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserInterface {

    public void displayMainMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public void displayPurchaseMenu(double amount) {
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: $" + String.format("%.2f", amount));
    }

    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please make a selection: ");
        return input.nextLine();
    }

    public String feedMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the value of your money (1, 2, 5, or 10): ");
        return input.nextLine();
    }

    public void printChange(int quarters, int dimes, int nickels) {
        System.out.println("Thank you for using our vending machine, here is your change.");
        System.out.println("Number of quarters: " + quarters);
        System.out.println("Number of dimes:    " + dimes);
        System.out.println("Number of nickels:  " + nickels);
    }

    public void printProductInfo(Product purchasedProduct) {
        System.out.println("Item Purchased: " + purchasedProduct.getName());
        System.out.println("Price:          " + purchasedProduct.getPrice());
        System.out.println("Item category:  " + purchasedProduct.getCategory());
    }

    public String selectProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the slot number: ");
        return input.nextLine();
    }

    public void productSoldOut() {
        System.out.println("Product is sold out. Please make another selection.");
    }

    public void printDispensingMessage(String category) {
        switch (category) {
            case "Chip":
                System.out.println("Crunch Crunch, Yum");
                break;
            case "Candy":
                System.out.println("Munch Munch, Yum!");
                break;
            case "Drink":
                System.out.println("Glug Glug, Yum!");
                break;
            case "Gum":
                System.out.println("Chew Chew, Yum!");
                break;
        }
    }

    public void displayInvalidBillMessage() {
        System.out.println("Please insert a $1, $2, $5, or $10 bill.");
    }

    public void displayInsertMoreMoney() {
        System.out.println("Please insert more money");
    }

    public void displayInvalidSlotSelectionMessage() {
        System.out.println("This is not a valid product. Please try again.");
    }

    public void displayInvalidMenuSelectionMessage() {
        System.out.println("Please enter a selection between 1 and 3");
    }


}


