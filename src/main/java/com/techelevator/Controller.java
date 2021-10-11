package com.techelevator;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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


        //Set up log file
        try {
            File log = new File("Log.txt");
            log.createNewFile();
            FileWriter myWriter = new FileWriter("Log.txt", false);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        while (isUserPresent) {


            userInterface.displayMainMenu();
            String userSelection = userInterface.getUserInput();
            switch (userSelection) {
                case "1":
                    vendingMachine.displayProducts();
                    System.out.println();
                    break;
                case "2":
                    purchase();
                    break;
                case "3":
                    isUserPresent = false;
                    break;
                default:
                    userInterface.displayInvalidMenuSelectionMessage();
                    break;
            }
        }
    }

    public void purchase(){
        Boolean isUserPresent = true;

        do {

            //Display Purchase Menu
            userInterface.displayPurchaseMenu(user.getCurrentMoneyProvided());

            //Get User Input
            String purchaseMenuUserSelection = userInterface.getUserInput();

            //If (1) Feed Money...
            if (purchaseMenuUserSelection.equals("1")) {
                String billInput = userInterface.feedMoney();
                int bill = 0;
                try {
                    bill = Integer.parseInt(billInput);
                } catch(NumberFormatException | NullPointerException e) {
                    userInterface.displayInvalidBillMessage();
                }
                if ((bill == 1 || bill == 2 || bill == 5 || bill == 10)) {
                    user.addMoney(bill);

                    try {
                        FileWriter myWriter = new FileWriter("Log.txt", true);
                        myWriter.write(dateAndTime().substring(0,22) + " FEED MONEY: \\$" + bill + ".00 \\$"
                                + String.format("%.2f", user.getCurrentMoneyProvided()) + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }


                else {
                    userInterface.displayInvalidBillMessage();
                }
            }

            //If (2) Select Product...
            else if (purchaseMenuUserSelection.equals("2")) {
                String slotChoice = userInterface.selectProduct();

                //Check if slot is valid
                // If valid, Enter Product into Purchase List, subtract price of product from currentMoneyProvided
                if (vendingMachine.isSlotValid(slotChoice)) {

                    if (vendingMachine.checkProductStock(slotChoice) < 1) {
                        userInterface.productSoldOut();
                    } else {
                        double priceOfPurchase = vendingMachine.getProduct(slotChoice).getPrice();
                        if (user.getCurrentMoneyProvided() >= priceOfPurchase) {

                            double moneyProvidedBeforePurchase = user.getCurrentMoneyProvided();

                            user.setCurrentMoneyProvided(user.getCurrentMoneyProvided() - priceOfPurchase);
                            user.addProductToPurchaseList(vendingMachine.getProduct(slotChoice));

                            try {
                                FileWriter myWriter = new FileWriter("Log.txt", true);
                                myWriter.write( dateAndTime().substring(0,22) + " "
                                        + vendingMachine.getProduct(slotChoice).getName() + " " + slotChoice
                                        + " \\$" + String.format("%.2f", moneyProvidedBeforePurchase) + " \\$"
                                        + String.format("%.2f", user.getCurrentMoneyProvided()) + "\n");
                                myWriter.close();
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }

                            userInterface.printProductInfo(vendingMachine.getProduct(slotChoice));

                            String category = vendingMachine.getProduct(slotChoice).getCategory();
                            if(category.equalsIgnoreCase("Chip"))
                                userInterface.printDispensingMessage("Chip");
                            if(category.equalsIgnoreCase("Candy"))
                                userInterface.printDispensingMessage("Candy");
                            if(category.equalsIgnoreCase("Drink"))
                                userInterface.printDispensingMessage("Drink");
                            if(category.equalsIgnoreCase("Gum"))
                                userInterface.printDispensingMessage("Gum");

                        } else {
                            userInterface.displayInsertMoreMoney();
                        }
                    }
                }
                else {
                    userInterface.displayInvalidSlotSelectionMessage();
                }
            }
            //If (3) Finish Transaction...
            else if (purchaseMenuUserSelection.equals("3")) {

                int quarters = 0;
                int dimes = 0;
                int nickels = 0;
                double currentMoneyProvided = user.getCurrentMoneyProvided();
                int currentMoneyProvidedInCents = (int) (currentMoneyProvided*100);

                quarters = currentMoneyProvidedInCents / 25;
                currentMoneyProvidedInCents = currentMoneyProvidedInCents % 25;
                dimes = currentMoneyProvidedInCents / 10;
                currentMoneyProvidedInCents = currentMoneyProvidedInCents % 10;
                nickels = currentMoneyProvidedInCents / 5;

                userInterface.printChange(quarters, dimes, nickels);

                try {
                    FileWriter myWriter = new FileWriter("Log.txt", true);
                    myWriter.write(dateAndTime().substring(0,22) + " GIVE CHANGE: \\$"
                            + String.format("%.2f", currentMoneyProvided) + " \\$0.00 \n");
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                isUserPresent = false;
                return;
            }

            //If input is not 1, 2, or 3, prompt user and get new input
            else {
                userInterface.displayInvalidMenuSelectionMessage();
            }
        } while (isUserPresent);
    }

    public String dateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy KK:mm:ss a", Locale.ENGLISH);
        return LocalDateTime.now().format(formatter);
    }

}
