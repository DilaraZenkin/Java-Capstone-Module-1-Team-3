package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Machine {

    //Placeholder for AuditEntry
    //private List<AuditEntry> auditEntryList = new ArrayList<>();

    private Map<String, Product> products;

    public Machine() {

        products = new HashMap<String, Product>();
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

        // Parse the input file
//    try{
//        Scanner machineFileStreamer = new Scanner(filePath);
//         while(machineFileStreamer.hasNextLine()) {
//             String line = machineFileStreamer.nextLine();
//             Product newProduct = new Product(line);
//             products.put(newProduct, )
//         }
//    }


        // for each line of the input file

            // create a new Product with NAME, CATEGORYNAME, PRICE
            // Product p = new Product(name, categoryName, price)

            // add that product to the products HashMap with the Key "slot" (ex: B2)


    }


}
