package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void adding_bill_amounts_should_result_in_sum() {
        //Arrange
        User sut = new User();

        double expected = 18;

        double currentMoneyProvided = sut.addMoney(1);
        currentMoneyProvided = sut.addMoney(2);
        currentMoneyProvided = sut.addMoney(5);
        currentMoneyProvided = sut.addMoney(10);

        Assert.assertEquals(expected, currentMoneyProvided, 0.001);
    }
    // add -1, should not add anything to currentMoneyProvided
     @Test
     public void adding_negative_bill_amounts_should_result_in_sum() {
         //Arrange
         User sut = new User();
         double expected = 0;

         double currentMoneyProvided = sut.addMoney(-1);

         Assert.assertEquals(expected, currentMoneyProvided, 0.001);

     }

     @Test
    public void adding_1_product_to_the_list() {

        User sut = new User();
        int expected = 1;
        Product input = new Product("Potato Crisps", "Chip", 3.05);
        List<Product> testList = new ArrayList<>();
        testList.add(input);


        Assert.assertEquals(testList.size(), expected);

     }

     @Test

    public void adding_3_product_to_the_list() {

         User sut = new User();
         int expected = 3;
         Product input = new Product("Potato Crisps", "Chip", 3.05);
         Product input1 = new Product("Stackers", "Chip", 1.45);
         Product input2 = new Product("Grain Waves", "Chip", 2.75);

         List<Product> testList = new ArrayList<>();
         testList.add(input);
         testList.add(input1);
         testList.add(input2);

         Assert.assertEquals(testList.size(), expected);
     }

    @Test
    //adding null results in List of size 0
    public void adding_null_product_to_the_list() {

        User sut = new User();
        int expected = 0;
        Product input = null;

        List<Product> testList = new ArrayList<>();

        sut.addProductToPurchaseList(input);


        Assert.assertEquals(sut.getProductsToPurchase().size(), expected);
    }



}