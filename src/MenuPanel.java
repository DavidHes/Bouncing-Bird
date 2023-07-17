import javax.swing.*;
import java.awt.Graphics;

public class MenuPanel extends MenuFundament {
    RateGamePanel rgp;
    ScoreboardPanel sbp;
    SettingsPanel settingspanel;
    SettingsList settingsList;
    GamePanel gamepanel;

    public MenuPanel() {
        add(startGameBut);
        add(scoreBoardBut);
        add(rateGameBut);
        add(settingsBut);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(titelBB, 44, -50, 350, 350, this);
        g.drawImage(grünbird, 184, 10, 60, 60, this);

        repaint();
    }
}
