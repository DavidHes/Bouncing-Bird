import javax.swing.*;

public class Gametesterneu{
    public static void main(String[] args) {

        Gamerunner frame = new Gamerunner();
        MenuFundament menuFundament = new MenuFundament();
        MenuController menuController = new MenuController();
        GameController gameController = new GameController();
        RateGamePanel rgp = new RateGamePanel();
        ScoreBoardPanel sbp = new ScoreBoardPanel();
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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);
}
        //   rgp.addController(menuController);
        //  sbp.addController(menuController);
        //  settingspanel.addController(menuController);
        //    menuPanel.addController(menuController);

    }
