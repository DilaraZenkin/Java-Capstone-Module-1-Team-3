package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

public class UserInterfaceTest {
    @Test

    public void text_order() {

        @FixMethodOrder(MethodSorters.NAME_ASCENDING)
        class LectureTest {


            @Before

            public void display_menu() {
                System.out.println("Please make a selection: ");
            }

            @After
            public void tear_down() {
                System.out.println("Please enter the value of your money (1, 2, 5, or 10): ");

            }

        }
    }
}


