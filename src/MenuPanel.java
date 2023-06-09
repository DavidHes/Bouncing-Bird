
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
public class MenuPanel extends MenuFundament{
    MenuController menuController;
	public MenuPanel() {

        menuController = new MenuController();

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
