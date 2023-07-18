import java.util.Observable;

public class Gametesterneu {

    public static void main(String[] args) {

        MenuController menuController = new MenuController();
        MenuFundament menuFundament = new MenuFundament();
        MenuPanel menuPanel = new MenuPanel();
        SettingsList settingsList = new SettingsList();

        // MenuFundament menuFundament = new MenuFundament();
        //  menuFundament.addObservable();
        SettingsPanel settingspanel = new SettingsPanel(menuController);
        settingsList.addObserver(menuFundament);

    }
}
