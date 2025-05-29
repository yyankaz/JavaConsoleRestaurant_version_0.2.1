package com.JavaConsoleRestaurant.Console.StaffMode;

import com.JavaConsoleRestaurant.Console.Signals.MainMenuSignal;
import com.JavaConsoleRestaurant.Console.StaffMode.ClientS.ClientSettings;
import com.JavaConsoleRestaurant.Console.StaffMode.MenuS.MenuSettings;
import com.JavaConsoleRestaurant.Utils.Utils;

public class StaffControl {

    private Utils utils;
    private MainMenuSignal mainMenuSignal;
    private ClientSettings clientSettings;
    private MenuSettings menuSettings;

    public StaffControl(Utils utils, ClientSettings clientSettings, MenuSettings menuSettings){
        this.utils = utils;
        this.clientSettings = clientSettings;
        this.menuSettings = menuSettings;
    }

    public void setMainMenuSignal(MainMenuSignal mainMenuSignal) {
        this.mainMenuSignal = mainMenuSignal;
    }

    public void passwordCheck(){
        String staffAccessPassword = "08052003";
        while(true){
            String password = utils.inputValidityCheckInt(Utils.TypeOfInput.PASSWORD, 8);
            if (password == null){
                return;
            }else if(password.equalsIgnoreCase(staffAccessPassword)){
                start();
                break;
            } else {
                System.out.println("\u001B[1m\u001B[91mWrong password.\u001B[0m");
            }
        }
    }

    public void start(){
        System.out.println("Welcome to Staff Mode!");
        String settingChoose = utils.inputValidityCheckString("Please choose what you want to do:","client settings",
                "menu settings", "back to main menu");
        switch (settingChoose){
            case "client settings" -> clientSettings.start();
            case "menu settings" -> menuSettings.start();
            case "back to main menu" -> mainMenuSignal.execute();
        }
    }


}
