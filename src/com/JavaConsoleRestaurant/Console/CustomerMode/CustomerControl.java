package com.JavaConsoleRestaurant.Console.CustomerMode;

import com.JavaConsoleRestaurant.Utils.Utils;

public class CustomerControl{

    private Utils utils;

    public CustomerControl(Utils utils){
        this.utils = utils;
    }

    public void customerIDCheck(){
        String answer = utils.inputValidityCheckString("Do you have customerID?","yes", "no");
        switch (answer){
            case "yes" -> System.out.println("pipa");
            case "no" -> System.out.println("popa");
        }
    }
}
