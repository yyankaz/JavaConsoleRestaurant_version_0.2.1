import com.JavaConsoleRestaurant.Console.ModeChooseStep;
import com.JavaConsoleRestaurant.Console.Signals.Staff.ClientSettingsSignal;
import com.JavaConsoleRestaurant.Console.Signals.MainMenuSignal;
import com.JavaConsoleRestaurant.Console.Signals.Staff.StaffStartSignal;
import com.JavaConsoleRestaurant.Console.StaffMode.ClientS.ClientSettings;
import com.JavaConsoleRestaurant.Console.StaffMode.MenuS.MenuSettings;
import com.JavaConsoleRestaurant.Console.StaffMode.StaffControl;
import com.JavaConsoleRestaurant.Utils.Utils;

import java.util.Scanner;


public class SignalContainer {
    private ModeChooseStep modeChooseStep;
    private Utils utils;

    private StaffControl staffControl;
    private ClientSettings clientSettings;
    private MenuSettings menuSettings;
    private MainMenuSignal mainMenuSignal;
    private StaffStartSignal staffStartSignal;
    private ClientSettingsSignal clientSettingsSignal;

    public SignalContainer() {
        Scanner scanner = new Scanner(System.in);
        this.utils = new Utils(scanner); // 1
        this.clientSettings = new ClientSettings(utils);
        this.menuSettings = new MenuSettings(utils);
        this.staffControl = new StaffControl(utils, clientSettings, menuSettings);
        this.modeChooseStep = new ModeChooseStep(utils, staffControl); // 2

        this.mainMenuSignal = new MainMenuSignal(modeChooseStep); // 3
        this.staffStartSignal = new StaffStartSignal(staffControl);
        this.clientSettingsSignal = new ClientSettingsSignal(clientSettings);

        // Связываем обратные зависимости
        this.utils.setMainMenuSignal(mainMenuSignal); // 4
        this.staffControl.setMainMenuSignal(mainMenuSignal);
        this.clientSettings.setStaffStartSignal(staffStartSignal);
        this.menuSettings.setStaffStartSignal(staffStartSignal);
        // Здесь можешь зарегистрировать остальные сигналы
    }

    public MainMenuSignal getMainMenuSignal() {
        return mainMenuSignal;
    }

}
