public class GameTester {

    public static void main(String[] args) {

        SettingsList settingsList = new SettingsList();
        MenuController menuController = new MenuController();
        MenuBasis menuBasis = new MenuBasis();

        SettingsPanel settingspanel = new SettingsPanel(menuController);
        settingsList.addObserver(menuBasis);

        MenuPanel menuPanel = new MenuPanel(menuController);


    }
}
