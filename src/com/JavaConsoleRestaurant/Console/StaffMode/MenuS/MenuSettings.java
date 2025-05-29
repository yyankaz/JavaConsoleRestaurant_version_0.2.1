package com.JavaConsoleRestaurant.Console.StaffMode.MenuS;

import com.JavaConsoleRestaurant.Console.Signals.Staff.StaffStartSignal;
import com.JavaConsoleRestaurant.Utils.Utils;

public class MenuSettings {
    private Utils utils;
    private StaffStartSignal staffStartSignal;

    public MenuSettings(Utils utils){
        this.utils = utils;
    }

    public void setStaffStartSignal(StaffStartSignal staffStartSignal) {
        this.staffStartSignal = staffStartSignal;
    }

    public void start(){
        String editingSet = utils.inputValidityCheckString("Please choose","add dish", "remove dish", "return");
        switch (editingSet){
            case "add dish" -> System.out.println("You want to add dish!");
            case "remove dish" -> System.out.println("You want to remove dish!");
            case "return" -> staffStartSignal.execute();
        }
    }
}
