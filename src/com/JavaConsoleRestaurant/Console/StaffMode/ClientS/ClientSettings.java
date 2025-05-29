package com.JavaConsoleRestaurant.Console.StaffMode.ClientS;

import com.JavaConsoleRestaurant.Console.Signals.Staff.StaffStartSignal;
import com.JavaConsoleRestaurant.Utils.Utils;

public class ClientSettings {
    private Utils utils;
    private StaffStartSignal staffStartSignal;
    //private AddClient addClient;
    //private RemoveClient removeClient;
    public ClientSettings(Utils utils){
        this.utils = utils;
        //this.addClient = addClient;
        //this.removeClient = removeClient;
    }

    public void setStaffStartSignal(StaffStartSignal staffStartSignal) {
        this.staffStartSignal = staffStartSignal;
    }

    public void start(){
        String editingSet = utils.inputValidityCheckString("Please choose","add client", "remove client", "return");
        switch (editingSet){
            case "add client" -> System.out.println("You want to add client!");
            case "remove client" -> System.out.println("You want to remove client!");
            case "return" -> staffStartSignal.execute();
        }
    }
}
