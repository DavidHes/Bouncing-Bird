import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JPanel;
import javax.swing.Timer;

//import GUI.MyPanel.MoveListener;
//import GUI.MyPanel.MyMouseListener;
public class GamePanel extends MenuFundament {
    int score = 0;
    int birdxPOS = 100;
    int birdyPOS = 300;
    int jumpheight = 70;
   private int drop = 5;
   private int gameoverdrop = 7;
    private Font myFont1 = new Font("Serif", Font.BOLD, 22);
   private Font myFont = new Font("Serif", Font.BOLD, 52);


    JButton restartBut;
    JButton addscore;

    boolean spielmenuvisible = false;
    boolean gameover = true;
    String gameovertext = "Game Over";
    String clickToStartText = "Click to Start!";
    String clearClickToStartText = "";
    Timer dropTimer = new Timer(20, new MoveListener());
    Timer  gameOverDropTimer = new Timer(10, new GameoverListener());
    Image tubeDown = new ImageIcon("/Users/uni/Desktop/tubeDown.png").getImage();
    Image tubeup = new ImageIcon("/Users/uni/Desktop/tube.png").getImage();

    public GamePanel() {

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);

        addscore= new JButton("Add Score");
        addscore.setBounds(144, 350, 150, 50);

        backToMenuBut.setBounds(144, 450, 150, 50);


        if (spielmenuvisible == true) {

            this.add(restartBut);
            this.add(addscore;
            this.add(backToMenuBut);
        }

       // this.addMouseListener(new MyMouseListener()); //new MyMouseListener() --> anaoynme innere Klasse, weil sie keinen Namen hat.

        //mouseadapter basis für mouselistener und mousemotionlistener, das spart einem Code, denn damit müsste man nur die methode
        //überschrieben, welche man braucht, Bsp. mousepressed, mouseentered, ..... --> dann kann man mit mouseadapter auch nur
        //mousepressed überschreiben.

        // -> das ist Lander

    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.setFont(myFont);
        g.drawString("" + score, 205, 100);
        g.drawImage(grünbird, birdxPOS, birdyPOS, 70, 50, this);

        if(spielmenuvisible == false) {
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString(clickToStartText, 150, 400);

            g.drawImage(tubeDown, 400, 0, 70, 300, this);
            g.drawImage(tubeup, 400, 418, 70, 350, this);
            g.drawImage(tubeDown, 600, 0, 70, 250, this);
            g.drawImage(tubeup, 600, 318, 70, 450, this);
        }

        if (birdyPOS >= getHeight() || birdyPOS <= 0) {
            gameover = true;
            myTimer.start();

            if(birdyPOS >= 720) {
                g.setColor(Color.BLACK);
                g.setFont(myFont1);
                g.drawString(gameovertext, 200, 360);

                myTimer.stop();
                time.stop();
                birdyPOS = 720;
                this.add(restartBut);
                this.add(backToMenuBut);
                this.add(addscore);
            }

        }
        repaint();
    }

    public void addController(GameController game) {
        this.gameController = game;
        restartBut.addActionListener((ActionListener) gameController);
        backToMenuBut.addActionListener((ActionListener) gameController);
        addscore.addActionListener((ActionListener) gameController);
    }
    public void spawnTube() {

    }
    public void getNextTubeCord (){

    }
    public void checkBorderCollusion (int birdYPOS, int birdXPOS) {

    }
    public void checkTubeCollusion (int birdYPOS, int birdXPOS) {

    }

}
