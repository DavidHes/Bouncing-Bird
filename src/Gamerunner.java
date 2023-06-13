import javax.swing.*;
import java.awt.*;

public class Gamerunner extends JFrame {

    GamePanel gamePanel;
    ScoreBoardPanel sbp;
    RateGamePanel rgp;
    MenuPanel menuPanel;
    public Gamerunner() {

        menuPanel = new MenuPanel();
        rgp = new RateGamePanel();
        sbp = new ScoreBoardPanel();
        gamePanel = new GamePanel();

        this.pack();
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(menuPanel);
    }

    public void setvisible(JPanel j){
        this.getContentPane().removeAll();
        this.getContentPane().add(j);

    }
}
