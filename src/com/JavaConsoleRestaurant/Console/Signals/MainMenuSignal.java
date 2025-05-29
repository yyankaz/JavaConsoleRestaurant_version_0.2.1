package com.JavaConsoleRestaurant.Console.Signals;

import com.JavaConsoleRestaurant.Console.ModeChooseStep;

public class MainMenuSignal implements Signals{

    private final ModeChooseStep modeChooseStep;

    public MainMenuSignal(ModeChooseStep modeChooseStep) {
        this.modeChooseStep = modeChooseStep;
    }

    @Override
    public void execute() {
        modeChooseStep.start();
    }
}
