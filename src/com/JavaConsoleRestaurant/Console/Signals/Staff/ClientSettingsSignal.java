package com.JavaConsoleRestaurant.Console.Signals.Staff;

import com.JavaConsoleRestaurant.Console.Signals.Signals;
import com.JavaConsoleRestaurant.Console.StaffMode.ClientS.ClientSettings;

public class ClientSettingsSignal implements Signals {

    private ClientSettings clientSettings;

    public ClientSettingsSignal(ClientSettings clientSettings){
        this.clientSettings = clientSettings;
    }

    @Override
    public void execute() {
        clientSettings.start();
    }
}
