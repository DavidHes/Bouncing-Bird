import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener{
    Gametesterneu gmn;

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


    public MenuController() {

        gmn = new Gametesterneu();

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
}
    public void addModel (RateGameList rgL, ScoreboardList sbL,SettingsList settL ){
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }

    @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == menuPanel.settingsBut ) {
                gmn.setvisible(settingspanel);
            }
        }
}
