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
}
