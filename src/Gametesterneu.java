public class Gametesterneu {


    public static GamePanel gamePanel;
    public static GameController gameController;
    public static void main(String[] args) {




        gamePanel = new GamePanel(gameController);
        gameController = new GameController(gamePanel);

        // Erzeuge GameController-Objekt und übergebe das GamePanel-Objekt

        MenuController menuController = new MenuController();
        MenuFundament menuFundament = new MenuFundament();
        MenuPanel menuPanel = new MenuPanel();





   /* MenuFundament menuFundament = new MenuFundament();
    MenuController menuController = new MenuController();
    GameController gameController = new GameController();
    RateGamePanel rgp = new RateGamePanel();
    ScoreboardPanel sbp = new ScoreboardPanel();
    SettingsPanel settingspanel = new SettingsPanel();
    GamePanel gamepanel = new GamePanel();
    RateGameList rgList = new RateGameList();
    ScoreboardList sbList = new ScoreboardList();
    SettingsList settList = new SettingsList();
    MenuPanel menuPanel = new MenuPanel();

        rgList.addObserver(rgp);
        sbList.addObserver(sbp);
        settList.addObserver(settingspanel);
        menuController.addModel(rgList, sbList,settList);
        gameController.addModel(rgList, sbList,settList);

        //myController.addView(myView);
        //tell View about Controller

        menuFundament.addController(menuController);
        gamepanel.addController(gameController);

}
        //   rgp.addController(menuController);
        //  sbp.addController(menuController);
        //  settingspanel.addController(menuController);
        //    menuPanel.addController(menuController);
*/
    }
    }
