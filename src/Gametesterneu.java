import javax.swing.*;

public class Gametesterneu{

    public static void main(String[] args) {

    JFrame frame = new JFrame();
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

        frame.add(rgp);
        frame.add(sbp);
        frame.add(menuPanel);
        frame.add(gamepanel);
        frame.add(settingspanel);

        //    frame.getContentPane().add(menuPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
}
        //   rgp.addController(menuController);
        //  sbp.addController(menuController);
        //  settingspanel.addController(menuController);
        //    menuPanel.addController(menuController);

    }
