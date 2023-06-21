import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    JFrame frame;
    MenuFundament menuFundament;
    RateGamePanel rgp;
    ScoreBoardPanel sbp;
    SettingsPanel settingspanel;
    GamePanel gamepanel;
    MenuPanel menuPanel;
    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;



    public MenuController() {

        frame = new JFrame();

        menuFundament = new MenuFundament();
        rgp = new RateGamePanel();
        sbp = new ScoreBoardPanel();
        settingspanel = new SettingsPanel();
        gamepanel = new GamePanel();
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        menuPanel = new MenuPanel();

        frame.add(rgp);
        frame.add(sbp);
        frame.add(settingspanel);
        frame.add(menuPanel);
        frame.add(gamepanel);

        //    frame.getContentPane().add(menuPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
}
    public void addModel (RateGameList rgL, ScoreboardList sbL,SettingsList settL ){
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }
    public void setVisible (JPanel jp){
        frame.add(jp);
    }


        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("läääufttttt");

            if (e.getSource() == menuFundament.backToMenuBut) {
                menuPanel.setVisible(true);
                settingspanel.setVisible(false);
                gamepanel.setVisible(false);
                rgp.setVisible(false);
                sbp.setVisible(false);
            }
            if (e.getSource() == menuFundament.scoreBoardBut) {
                System.out.println("menzpanel button funktionier");
                settingspanel.setVisible(false);
                menuPanel.setVisible(false);
                gamepanel.setVisible(false);
                rgp.setVisible(false);
                sbp.setVisible(true);

            }

            if (e.getSource() == menuFundament.settingsBut) {
                settingspanel.setVisible(true);
                menuPanel.setVisible(false);
                gamepanel.setVisible(false);
                rgp.setVisible(false);
                sbp.setVisible(false);
                System.out.println("settings button funktionier");
            }

            if (e.getSource() == menuFundament.startGameBut) {
                settingspanel.setVisible(false);
                menuPanel.setVisible(false);
                gamepanel.setVisible(true);
                rgp.setVisible(false);
                sbp.setVisible(false);
                System.out.println("startgame button funktionier");
            }

        }
    }

