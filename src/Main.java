import com.JavaConsoleRestaurant.Console.ModeChooseStep;
import com.JavaConsoleRestaurant.Utils.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SignalContainer signalContainer = new SignalContainer();
        signalContainer.getMainMenuSignal().execute();
    }
}