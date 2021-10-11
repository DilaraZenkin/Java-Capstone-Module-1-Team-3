package com.techelevator;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {

		UserInterface mainUI = new UserInterface();
		Machine vendingMachine = new Machine();
		User user = new User();
		Controller vendingMachineController = new Controller(vendingMachine, mainUI, user);

	}
}
