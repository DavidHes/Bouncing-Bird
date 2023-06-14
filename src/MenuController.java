import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener{

    MenuFundament menuFundament;
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

        menuFundament = new MenuFundament();
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

            if (e.getSource() == gamepanel.backToMenuBut) {
                menuPanel.setVisible(true);
                gamepanel.setVisible(false);
            }
        if (e.getSource() == menuFundament.scoreBoardBut) {
            System.out.println("button funktionier");
            settingspanel.setVisible(false);
            menuPanel.setVisible(false);
            gamepanel.setVisible(false);
            rgp.setVisible(false);
            sbp.setVisible(true);
            System.out.println("button funktionier");
        }
        }
}
