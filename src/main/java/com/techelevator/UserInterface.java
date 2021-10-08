package com.techelevator;

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
        String userSelection = input.nextLine();
        //System.out.println("User selection: " + userSelection);
        return userSelection;
    }

    public int feedMoney() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the value of your money (1, 2, 5, or 10)");
        String billDenomination = input.nextLine();
        return Integer.parseInt(billDenomination);

    }

    public String selectProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the slot number ");
        return input.nextLine();
    }

    public void finishTransaction(){
        System.out.println("Your transaction is finished!");
    }

    public void displayCurrentMoneyProvided(double amount) {
        System.out.println("Current Money Provided: $" + String.format("%.2f", amount));
    }

}
