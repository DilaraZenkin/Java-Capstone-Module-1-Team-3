package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class UserTests {


    @Test
    public void adding_3_dollar_bill_should_not_add_to_currentMoneyProvided() {

        // Arrange
        User sut = new User();
        double expected = 0;

        // Act
        double currentMoneyProvided = sut.addMoney(3);

        // Assert
        Assert.assertEquals(expected, currentMoneyProvided, 0.001);
    }

    @Test
    public void adding_2_dollar_bill_should_result_in_currentMoneyProvided_equals_2() {

        // Arrange
        User sut = new User();
        double expected = 2;

        // Act
        double currentMoneyProvided = sut.addMoney(2);

        // Assert
        Assert.assertEquals(expected, currentMoneyProvided, 0.001);
    }

    // add a $1, $2, $5, and $10, should equal $18
    // adding $0.99 should not add anything to currentMoneyProvided
    // add -1, should not add anything to currentMoneyProvided




    //addProductToPurchaseList
    //adding one product to purchase list results in List of size 1
    //adding three products to purchase list results in List of size 3
    //adding null results in List of size 0

}
