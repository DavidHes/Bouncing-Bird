import java.io.ObjectStreamException;
import java.util.Observable;

public class Gametesterneu {

    public static void main(String[] args) {

        SettingsList settingsList = new SettingsList();
        MenuController menuController = new MenuController();
        MenuFundament menuFundament = new MenuFundament();

        SettingsPanel settingspanel = new SettingsPanel(menuController);
        settingsList.addObserver(menuFundament);

        MenuPanel menuPanel = new MenuPanel();


        // MenuFundament menuFundament = new MenuFundament();
        //  menuFundament.addObservable();

    }
}
