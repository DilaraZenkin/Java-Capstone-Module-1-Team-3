package com.techelevator;

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
                    userInterface.displayInvalidMenuSelectionMessage();
                    break;
            }

        }


    }

    public void displayVendingMachineItems(){
        vendingMachine.displayProducts();
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
                if ((bill == 1 || bill == 2 || bill == 5 || bill == 10))
                    user.addMoney(bill);
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
                            user.setCurrentMoneyProvided(user.getCurrentMoneyProvided() - priceOfPurchase);
                            user.addProductToPurchaseList(vendingMachine.getProduct(slotChoice));
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
                isUserPresent = false;
                return;
            }

            //If input is not 1, 2, or 3, prompt user and get new input
            else {
                userInterface.displayInvalidMenuSelectionMessage();

            }
        } while (isUserPresent);
    }

    public void exit() {

    }

}
