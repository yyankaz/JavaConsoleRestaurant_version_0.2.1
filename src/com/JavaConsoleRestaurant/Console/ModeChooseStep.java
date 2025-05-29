package com.JavaConsoleRestaurant.Console;

import com.JavaConsoleRestaurant.Console.StaffMode.StaffControl;
import com.JavaConsoleRestaurant.Utils.*;

public class ModeChooseStep {
    private Utils utils;
    private StaffControl staffControl;

    public ModeChooseStep(Utils utils, StaffControl staffControl) {
        this.utils = utils;
        this.staffControl = staffControl;
    }

    public void start(){
        greetings();
        String mode = utils.inputValidityCheckString("Please choose mode:", "customer", "staff");
        switch (mode){
            case "customer" -> System.out.println("Customer");
            case "staff" -> staffControl.passwordCheck();
            default -> System.out.println("Unexpected statement.");
        }
    }

    private void greetings(){
        System.out.println("\u001B[93mWelcome to our Java-console restaurant!\uD83C\uDF1E\u001B[0m");
    }
}
