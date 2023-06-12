
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPanel extends MenuFundament{
    MenuController menuController;
    RateGamePanel rgp;
    ScoreBoardPanel sbp;
    SettingsPanel settingspanel;
    GamePanel gamepanel;
    MenuPanel menuPanel;
	public MenuPanel() {

        menuController = new MenuController();
        rgp = new RateGamePanel();
        sbp = new ScoreBoardPanel();
        settingspanel = new SettingsPanel();
        gamepanel = new GamePanel();
        menuPanel = new MenuPanel();

            add(startGameBut);
            add(scoreBoardBut);
            add(rateGameBut);
            add(settingsBut);

         //   startGameBut.setVisible(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);

            g.drawImage(titelBB, 44, -50, 350, 350, this);
            g.drawImage(grünbird, 184, 10, 70, 50, this);
            //g.drawString("Designer: Majd, Ekber, David und Yasin", 100 , 738);

            repaint();

        }

    }
