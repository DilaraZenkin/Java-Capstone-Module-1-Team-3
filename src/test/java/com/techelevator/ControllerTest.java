package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ControllerTest {
    @Test

    public void case_1() {
        UserInterface ui = new UserInterface();
        Machine mn = new Machine();
        User us = new User();
        Controller ct = new Controller(mn, ui, us);

        Boolean isUserPresent = true;
        String userSelection = "1";

//        mn.displayProducts();
//        ct.startProgram();
//        Assert.assertEquals();
// if(userSelection ==1)
        //return vendingMachine.displayProducts

    }
}