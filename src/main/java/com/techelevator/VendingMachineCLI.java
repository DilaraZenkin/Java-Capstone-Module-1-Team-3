package com.techelevator;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!

		UserInterface mainUI = new UserInterface();


		mainUI.displayMainMenu();
		System.out.println("-----------------");
		mainUI.displayPurchaseMenu();
		System.out.println("-----------------");

		//Make a test array full of products
		Product[] testingArray = new Product[4];

		Product potatoCrisps = new Product("Potato Crisps", "Chip", 2.95);
		Product cocaCola = new Product("Coca Cola", "Drink", 5.05);
		Product chocolateBar = new Product("Chocolate Bar", "Candy", 3.00);
		Product chewingGum = new Product("Chewing Gum", "Gum", 1.55);
		testingArray[0] = potatoCrisps;
		testingArray[1] = cocaCola;
		testingArray[2] = chocolateBar;
		testingArray[3] = chewingGum;

		for (int i = 0; i < 4; i++) {
			System.out.println("-----------------");
			System.out.println("Product Name:   " + testingArray[i].getName());
			System.out.println("Category Name:  " + testingArray[i].getCategory());
			System.out.println("Price:          " + testingArray[i].getPrice());
			System.out.println("Stock Count:    " + testingArray[i].getName());
		}


	}
}
