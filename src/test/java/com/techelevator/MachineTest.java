package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MachineTest {
    @Test

    public void slot_is_not_valid() {
        Machine me = new Machine();
        String input = "A9";

        boolean output = me.isSlotValid(input);
        Assert.assertFalse(output);
    }

    @Test

    public void slot_is_valid() {
        Machine me = new Machine();
        String input = "A1";

        boolean output = me.isSlotValid(input);
        Assert.assertTrue(output);
    }

    @Test

    public void check_product_stock() {
        Machine me = new Machine();
        String slot = "A1";
        int input = 5;

        int output = me.checkProductStock(slot);
        Assert.assertEquals(input, output);
    }

    //@Test

//    public void check_product_stock2() {
//        Machine me = new Machine();
//        String slot = "A8";
//        int input = null;
//
//        int output = me.checkProductStock(slot);
//        Assert.assertEquals(input, output);
//    }


}
