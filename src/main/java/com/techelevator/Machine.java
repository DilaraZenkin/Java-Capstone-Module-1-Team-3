package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Machine {

    private Map<String, Product> products;

    public Machine() {
        products = new TreeMap<String, Product>();
        importVendingMachineDataFile();
    }

    public void importVendingMachineDataFile() {

        Scanner input = new Scanner(System.in);

        //Populate the Map of products by importing Vending Machine Data File
        String filePath = "vendingmachine.csv";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("The file does not exist!");
            return;
        }

        //Parse the input file
        try (Scanner machineFileStreamer = new Scanner(file)){
            while(machineFileStreamer.hasNextLine()) {
                String line = machineFileStreamer.nextLine();
                String[] pieces = line.split("\\|");

                //make new product
                double price = Double.parseDouble(pieces[2]);
                Product p = new Product(pieces[1], pieces[3], price);

                //add the product to the products Hashmap with the key pieces[0]
                products.put(pieces[0], p);
             }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found!");
        }
    }

    public void displayProducts() {

        System.out.println("Slot   Price   # Remaining    Item Name");
        System.out.println("----   -----   -----------    ---------");
        for (String product : products.keySet()) {
            System.out.print(product);
            System.out.println( "     $" + String.format("%.2f", products.get(product).getPrice())
                    + "   " + products.get(product).getStockCount() + "              "
                    + products.get(product).getName());
        }
    }

    public int checkProductStock(String slot){
        return products.get(slot).getStockCount();
    }

    public Boolean isSlotValid(String slot) {
        if (products.containsKey(slot)) {
            return true;
        }
        return false;
    }

    public Product getProduct(String slot) {
        return products.get(slot);
    }

}
