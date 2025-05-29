package com.JavaConsoleRestaurant.Console.Signals.Staff;

import com.JavaConsoleRestaurant.Console.Signals.Signals;
import com.JavaConsoleRestaurant.Console.StaffMode.MenuS.MenuSettings;

public class MenuSettingsSignal implements Signals {

    private MenuSettings menuSettings;

    public MenuSettingsSignal(MenuSettings menuSettings){
        this.menuSettings = menuSettings;
    }

    @Override
    public void execute() {
        menuSettings.start();
    }
}
