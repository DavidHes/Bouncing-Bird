import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends MenuFundament {
    int score = 0;
    int birdxPOS = 75, birdyPOS = 300;
    int birdV = 0, birdA = 8, birdI = 1; //birdA = Beschleunigung, birdV = Geschwidnigkeit
    final int tubeXValocity = 5, tubeWidth = 50;
    final int width = 700;
    int[] tube = {width, width + width / 2};
    int[] gap = {(int) (Math.random() * (frameHeight - 250)), (int) (Math.random() * (frameHeight - 250))};

    // int jumpheight = 70;
    // private int drop = 5;
    //private int gameoverdrop = 7;
    private Font myFont1 = new Font("Serif", Font.BOLD, 22);
    private Font myFont = new Font("Serif", Font.BOLD, 52);

    JButton restartBut, addscore;
    boolean spielmenuvisible = false, gameover = false;
    private boolean hasExecuted = false;

    String gameovertext = "Game Over";
    String clickToStartText = "Click with mouse or press Enter to Start!", clearClickToStartText = "";
    // Timer dropTimer = new Timer(20, new MoveListener());
    // Timer  gameOverDropTimer = new Timer(10, new GameoverListener());

    Image tubeDown = new ImageIcon("/Users/uni/Desktop/tubeDown.png").getImage();
    Image tubeup = new ImageIcon("/Users/uni/Desktop/tube.png").getImage();
    GameController gameController;
    JTextField scorename = new JTextField("Name...", 20);
    private MouseListener mouseListener;
    private KeyListener keyListener;


    public GamePanel(GameController gameController) {
        super();
        this.gameController = gameController;

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);

        addscore = new JButton("Add Score");
        addscore.setBounds(144, 350, 150, 50);

        backToMenuBut.setBounds(144, 450, 150, 50);

       // setFocusable(true);
       // requestFocus();

        addController(gameController);


      /*  if (spielmenuvisible) {
            this.gameoverbild();
        }*/
    }


    public void startgame() {
        clickToStartText = clearClickToStartText;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameover == false) {
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString(clickToStartText, 150, 400);
            spawnTube(g);
            drawbird(g);
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString("" + score, 205, 100);

        } else {
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString(clickToStartText, 150, 400);
            spawnTube(g);
            drawbird(g);
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString("" + score, 205, 100);
        }
    }


    public void addController(GameController game) {
        this.gameController = game;
        addMouseListener(gameController);
        addKeyListener(gameController);
        if(gameover == true) {
            add(backToMenuBut);
            add(restartBut);
            add(addscore);
            add(scorename);
        }

        setFocusable(true);
    }

    public void spawnTube(Graphics g) {

        for (int i = 0; i < 2; i++) {
            g.setColor(Color.RED);
            g.fillRect(tube[i], 0, tubeWidth, frameHeight);

            g.setColor(new Color(41, 183, 229));
            g.fillRect(tube[i], gap[i], tubeWidth, 100);

            if (tube[i] + tubeWidth <= 0) {
                tube[i] = width;
                gap[i] = (int) (Math.random() * (frameHeight - 250));
            }
        }
    }

    public void gameoverbild() {
        ActionListener actionListener;

        add(restartBut);
        add(backToMenuBut);
        add(addscore);


    }

    public void restartTheGame() {
        score = 0;
        birdxPOS = 75 ; birdyPOS = 300;
        birdV = 0; birdA = 8; birdI = 1;
        tube [0] = width;
        tube [1] = width + width/2;
        gap [0] = (int) (Math.random() * (frameHeight - 250));
        gap [1] = (int) (Math.random() * (frameHeight - 250));
        gameover = false;
        remove(backToMenuBut);
        remove(restartBut);
        remove(addscore);
        remove(scorename);

        spielmenuvisible = false;
        clickToStartText = "Click with mouse or press Enter to Start!";
        scorename = new JTextField("Name...", 20);


        repaint();

    }

    public void drawbird(Graphics g) {
        g.drawImage(grünbird, birdxPOS, birdyPOS + birdV, 25, 25, this);
    }

    public void checkBorderCollusion() {
        System.out.println(birdyPOS + birdV);

        if (!(birdyPOS + birdV >= 0 && birdyPOS + birdV <= 750)) {
            System.out.println(birdyPOS + " + " + frameHeight);
            System.out.println("Border getroffen");
            gameover = true;
            spielmenuvisible = true;
            gameoverbild();

        }
    }

    public void changebirdcord() {
      //  if (clickToStartText == clearClickToStartText && gameover == false) {

            birdA = -8;
        System.out.println("haa");
       // }
    }

    public void dropbird() {
        if (clickToStartText == clearClickToStartText && gameover == false) {
            birdA += birdI;
            birdV += birdA;
        }
    }

    public void movetube() {
        if (clickToStartText == clearClickToStartText && gameover == false) {
            tube[0] -= tubeXValocity;
            tube[1] -= tubeXValocity;
        }
    }


    public JButton getRestartButton() {
        return restartBut;
    }

    public void updateScore() {
        for (int i = 0; i < 2; i++) {
            if(75 == tube[i] + tubeWidth) {
                score++;
            }
        }
    }

    public void backToMenu() {
        MenuController menuController = new MenuController();
        backToMenuBut.addActionListener(menuController);

    }

    public void checkTubeCollusion() {

        for (int i = 0; i < 2; i++) {
            if (tube[i] <= 100 && tube[i] + tubeWidth >= 100 || tube[i] <= 75 && tube[i] + tubeWidth >= 75) {
                if ((birdyPOS + birdV) >= 0 && (birdyPOS + birdV) <= gap[i]
                        || (birdyPOS + birdV + 25) >= gap[i] + 100 && (birdyPOS + birdV + 25) <= frameHeight) {
                    gameover = true;
                    spielmenuvisible = true;
                    System.out.println("Tube getroffen");
                    gameoverbild();

                }
            }
        }
    }
}
