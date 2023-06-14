
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class MenuFundament extends JPanel implements Observer {
    JButton startGameBut, scoreBoardBut, settingsBut , rateGameBut, backToMenuBut;

    MenuController menuController;

    GameController gameController;

    Image titelBB = new ImageIcon("/Users/uni/Desktop/BouncingBirdTitel.png").getImage();
    Image titelBwB = new ImageIcon("/Users/uni/Desktop/background_18.png").getImage();
    Image grünbird = new ImageIcon("/Users/uni/Desktop/GrünB.png").getImage();


    public MenuFundament() {

        setPreferredSize(new Dimension(438, 768));
        this.setLayout(null);
        //	this.setBackground(new Color(185, 220, 255));

        startGameBut = new JButton("Start Game");
        scoreBoardBut = new JButton("Scoreboard");
        settingsBut = new JButton("Settings");
        rateGameBut = new JButton("Rate Game");
        backToMenuBut = new JButton("Back to Menu");

       // startGameBut.addActionListener(new ButtonListener());
      //  scoreBoardBut.addActionListener(new ButtonListener());
       // settingsBut.addActionListener(new ButtonListener());
     //   rateGameBut.addActionListener(new ButtonListener());

        startGameBut.setBounds(144, 250, 150, 50);
        scoreBoardBut.setBounds(144, 350, 150, 50);
        settingsBut.setBounds(144, 450, 150, 50);
        rateGameBut.setBounds(144, 550, 150, 50);
        backToMenuBut.setBounds(144, 350, 150, 50);

    }

    public void addController(MenuController menu) {
        this.menuController = menu;
        rateGameBut.addActionListener(menuController);
        startGameBut.addActionListener(menuController);
        scoreBoardBut.addActionListener(menuController);
        settingsBut.addActionListener(menuController);
        backToMenuBut.addActionListener(menuController);

    }

    @Override
    public void update(Observable o, Object arg) {

    }


    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(titelBwB, 0, 0, 438, 768, this);
        repaint();

    }
}

