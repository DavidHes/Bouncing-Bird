
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class MenuBasis extends JPanel implements Observer {
    JButton startGameBut, scoreBoardBut, settingsBut , rateGameBut, backToMenuBut;
    final int frameWidth = 435, frameHeight = 750;
    private MenuController menuCon;
    static String aktuellerSkin = null;
    static String aktuellerBG = null;

    GameController gameController;

    static Image titelBB = new ImageIcon("BouncingBirdTitel.png").getImage();
    static Image titelBwB;
    static Image grünbird; //= new ImageIcon(aktuellesterPfad).getImage();


    public MenuBasis() {

        setPreferredSize(new Dimension(frameWidth, frameHeight));
        this.setLayout(null);


        startGameBut = new JButton("Start Game");
        scoreBoardBut = new JButton("Scoreboard");
        settingsBut = new JButton("Settings");
        rateGameBut = new JButton("Rate Game");
        backToMenuBut = new JButton("Back to Menu");

        startGameBut.setBounds(144, 250, 150, 50);
        scoreBoardBut.setBounds(144, 350, 150, 50);
        settingsBut.setBounds(144, 450, 150, 50);
        rateGameBut.setBounds(144, 550, 150, 50);
        backToMenuBut.setBounds(144, 650, 150, 50);

    }

    public void addController(MenuController menuCon) {
        this.menuCon = menuCon;
        rateGameBut.addActionListener(menuCon);
        startGameBut.addActionListener(menuCon);
        scoreBoardBut.addActionListener(menuCon);
        settingsBut.addActionListener(menuCon);
        backToMenuBut.addActionListener(menuCon);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            if (arg.toString().charAt(0) == "VOGELSKIN".charAt(0)) {
                aktuellerSkin = arg.toString();
                System.out.println("test: " + aktuellerSkin);
                grünbird = new ImageIcon(aktuellerSkin).getImage();
            }else if (arg.toString().charAt(0) == "HINTERGRUND".charAt(0)) {
                aktuellerBG = arg.toString();
                System.out.println("test: " + aktuellerBG);
                titelBwB = new ImageIcon(aktuellerBG).getImage();
                GamePanel.backgroundColor = aktuellerBG;

            } else if(arg instanceof ArrayList<?>) {
                ScoreboardPanel.scoreLabel.setText(arg.toString());
            }
        } else {
            System.out.println("gehhhhhhht net");
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(titelBwB, 0, 0, frameWidth, frameHeight, this);
        repaint();

    }
}

