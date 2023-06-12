import javax.swing.*;

public class Gametesterneu extends JFrame{

        MenuFundament menuFundament;
        MenuController menuController;
        GameController gameController;
        RateGamePanel rgp;
        ScoreBoardPanel sbp;
        SettingsPanel settingspanel;
        GamePanel gamepanel;
        RateGameList rgList;
        ScoreboardList sbList;
        SettingsList settList;
        MenuPanel menuPanel;

    public Gametesterneu() {

        menuFundament = new MenuFundament();
        menuController = new MenuController();
        gameController = new GameController();
        rgp = new RateGamePanel();
        sbp = new ScoreBoardPanel();
        settingspanel = new SettingsPanel();
        gamepanel = new GamePanel();
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        menuPanel = new MenuPanel();

    rgList.addObserver(rgp);
        sbList.addObserver(sbp);
        settList.addObserver(settingspanel);
        menuController.addModel(rgList, sbList,settList);
        gameController.addModel(rgList, sbList,settList);

        //myController.addView(myView);
        //tell View about Controller
        menuFundament.addController(menuController);
        gamepanel.addController(gameController);

          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.getContentPane().add(gpanel);
        this.pack();
        this.setVisible(true);
        this.getContentPane().add(menuPanel);


}

    public void setvisible(JPanel j){
        this.getContentPane().removeAll();
        this.getContentPane().add(j);

    }

        //   rgp.addController(menuController);
        //  sbp.addController(menuController);
        //  settingspanel.addController(menuController);
        //    menuPanel.addController(menuController);




    }
