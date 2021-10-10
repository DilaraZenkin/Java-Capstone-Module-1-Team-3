package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ProductTests {

    @Test
    public void remove_product_successfully() {

        // Arrange
        User sut = new User();
        Product p = new Product("Kettle Chips", "Chip", 4.35);
        int stockCount = p.getStockCount();

        // Act
        sut.addProductToPurchaseList(p);
        int stockCountAfterAddingToPurchaseList = p.getStockCount();

        // Assert
        Assert.assertNotEquals(stockCount, stockCountAfterAddingToPurchaseList);

    }

    @Test

    public void products_category() {

        Product p = new Product("Kettle Chips", "Chip", 4.35);
        String category = "Chip";

        String outcome = p.getCategory();

        Assert.assertEquals(category,outcome);


    }

    @Test

            public void products_price() {

        Product p = new Product("Kettle Chips", "Chip", 4.35);
        double expected = 4.35;

        double outcome = p.getPrice();

        Assert.assertEquals(expected, outcome, 0.001);
    }
}
