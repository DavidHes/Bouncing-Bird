import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GamePanel extends MenuFundament {
    int score = 0;
    int birdxPOS = 75, birdyPOS = 300;
    int birdV = 0, birdA = 8, birdI = 1; //birdA = Beschleunigung, birdV = Geschwidnigkeit
    final int tubeXValocity = 5, tubeWidth = 50;
    final int width = 700;
    int[] tube = {width, width + width / 2};
    int[] gap = {(int) (Math.random() * (frameHeight - 250)), (int) (Math.random() * (frameHeight - 250))};

    private Font myFont1 = new Font("Serif", Font.BOLD, 28);
    private Font myFont = new Font("Serif", Font.BOLD, 23);
    private Font gameoverfont = new Font("Serif", Font.BOLD, 52);

    JButton restartBut, addscore;
    boolean spielmenuvisible = false, gameover = false;
    private boolean hasExecuted = false;

    String gameovertext = "Game Over";
    String clickToStartText = "Click with mouse or press Enter to Start!", clearClickToStartText = "";


    // Timer dropTimer = new Timer(20, new MoveListener());
    // Timer  gameOverDropTimer = new Timer(10, new GameoverListener());

    Image tubeDown = new ImageIcon("/Users/uni/Desktop/tubeDown.png").getImage();
    Image tubeup = new ImageIcon("/Users/uni/Desktop/tube.png").getImage();

    JTextField scorename;

    private MouseListener mouseListener;
    private KeyListener keyListener;


    public GamePanel(GameController gameController, ActionListener actionListener) {
        super();
        this.gameController = gameController;
        this.addMouseListener(gameController);
        this.addKeyListener(gameController);
        this.setFocusable(true);

        // überflüssig
       // addController(gameController);

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);

        scorename = new JTextField("Name.....");
        scorename.setBounds(144, 350, 150, 50);
        scorename.setEditable(true);
        scorename.setVisible(true);
        scorename.addActionListener(actionListener);


        addscore = new JButton("Add Score");
        addscore.setBounds(144, 450, 150, 50);

        backToMenuBut.setBounds(144, 550, 150, 50);
        backToMenuBut.addActionListener(actionListener);

        setFocusable(true);
        requestFocusInWindow();
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
            g.setFont(myFont);
            g.drawString(clickToStartText, 11, 400);
            spawnTube(g);
            drawbird(g);
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString("" + score, 205, 100);

            repaint();

        } else {
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString(clickToStartText, 11, 400);
            spawnTube(g);
            drawbird(g);
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString("" + score, 205, 100);

            repaint();
        }

        if(gameover == true){
            g.setColor(Color.BLACK);
            g.setFont(gameoverfont);
            g.drawString(gameovertext, 88, 200);
        }
    }

    public void addController(GameController game) {
        this.gameController = game;
        addMouseListener(gameController);
        addKeyListener(gameController);

      //  if(gameover == true) {
       //     add(restartBut);
       //     add(addscore);
        //    add(scorename);
        //    add(backToMenuBut);
      //  }

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

       this.add(restartBut);
       this.add(backToMenuBut);
       this.add(scorename);
       this.add(addscore);

        repaint();
        revalidate();

    }

    public void addTheScore() {

      String name = scorename.getText();
     //vllt an der falschen Stelle
      //addscore(score,name);
        scorename.repaint();

    }

    public void restartTheGame() {

        clickToStartText = "Click with mouse or press Enter to Start!";
        score = 0;
        birdxPOS = 75 ; birdyPOS = 300;
        birdV = 0; birdA = 8; birdI = 1;
        tube [0] = width;
        tube [1] = width + width/2;
        gap [0] = (int) (Math.random() * (frameHeight - 250));
        gap [1] = (int) (Math.random() * (frameHeight - 250));
        gameover = false;
        spielmenuvisible = false;

        remove(backToMenuBut);
        remove(restartBut);
        remove(addscore);
        remove(scorename);

        setFocusable(true);
        requestFocusInWindow();

        repaint();

    }

    public void drawbird(Graphics g) {

        g.drawImage(grünbird, birdxPOS, birdyPOS + birdV, 40, 40, this);
    }

    public void checkBorderCollusion() {
        System.out.println(birdyPOS + birdV);

        if (!(birdyPOS + birdV >= 0 && birdyPOS + birdV + 40 <= frameHeight)) {
            System.out.println(birdyPOS + " + " + frameHeight);
         //   System.out.println("Border getroffen");
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

    public void checkTubeCollusion() {

        for (int i = 0; i < 2; i++) {

            //if tube in front and on bird or is behind or on bird or bird is in the gap
            if (tube[i] <= 115 && tube[i] + tubeWidth >= 115 || tube[i] <= 75 && tube[i] + tubeWidth >= 75) {
                // if bird is over gap
                if ((birdyPOS + birdV) >= 0 && (birdyPOS + birdV) <= gap[i]
                        //or under gap
                        || (birdyPOS + birdV + 40) >= gap[i] + 100 && (birdyPOS + birdV + 40) <= frameHeight) {
                    gameover = true;
                    spielmenuvisible = true;
                    System.out.println("Tube getroffen");
                    gameoverbild();

                }
            }
        }
    }
}
