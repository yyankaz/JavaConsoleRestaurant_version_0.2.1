package com.JavaConsoleRestaurant.Console.Signals.Staff;

import com.JavaConsoleRestaurant.Console.Signals.Signals;
import com.JavaConsoleRestaurant.Console.StaffMode.StaffControl;

public class StaffStartSignal implements Signals {

    private StaffControl staffControl;

    public StaffStartSignal(StaffControl staffControl){
        this.staffControl = staffControl;
    }

    @Override
    public void execute() {
        staffControl.start();
    }
}
