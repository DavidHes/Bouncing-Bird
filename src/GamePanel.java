import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

public class GamePanel extends MenuFundament {
    int score = 0;
    int birdxPOS = 100, birdyPOS = 300;
    int birdV = 0, birdA = 8, birdI = 1;
    final int tubeXValocity = 5, tubeWidth = 50;
    int tube = width + 10;
    int gap = (int) (Math.random() * HEIGHT);

    // int jumpheight = 70;
    // private int drop = 5;
    //private int gameoverdrop = 7;
    private Font myFont1 = new Font("Serif", Font.BOLD, 22);
    private Font myFont = new Font("Serif", Font.BOLD, 52);

    JButton restartBut, addscore;
    boolean spielmenuvisible = false;
    boolean gameover = true;
    String gameovertext = "Game Over";
    String clickToStartText = "Click to Start!";
    String clearClickToStartText = "";
    // Timer dropTimer = new Timer(20, new MoveListener());
    // Timer  gameOverDropTimer = new Timer(10, new GameoverListener());
    Image tubeDown = new ImageIcon("/Users/uni/Desktop/tubeDown.png").getImage();
    Image tubeup = new ImageIcon("/Users/uni/Desktop/tube.png").getImage();

    public GamePanel() {

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);

        addscore = new JButton("Add Score");
        addscore.setBounds(144, 350, 150, 50);

        backToMenuBut.setBounds(144, 450, 150, 50);

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
        g.setFont(myFont1);
        g.drawString(clickToStartText, 150, 400);
        g.drawString("" + score, 205, 100);

        drawbird(g);
        spawnTube(g);

        //   g.drawImage(tubeDown, 400, 0, 70, 300, this);
        //   g.drawImage(tubeup, 400, 418, 70, 350, this);
        //   g.drawImage(tubeDown, 600, 0, 70, 250, this);
        //   g.drawImage(tubeup, 600, 318, 70, 450, this);
        //}

        //    myTimer.start();

    }

    public void addController(GameController game) {
        this.gameController = game;
        //restartBut.addActionListener(gameController);
        backToMenuBut.addActionListener(gameController);
        scoreBoardBut.addActionListener(gameController);

        // addscore.addActionListener(gameController);
    }

    public void spawnTube(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(tube, 0, tubeWidth, height);

        g.setColor(new Color(90, 180, 224));
        g.fillRect(tube, gap, tubeWidth, 100);
    }

    public void drawbird(Graphics g) {
        g.drawImage(grünbird, birdxPOS, birdyPOS + birdV, 70, 50, this);
        //  g.draw
    }

    public void checkBorderCollusion() {
        if (birdyPOS >= getHeight() || birdyPOS <= 0) {
            gameover = true;
        }

        if (birdyPOS >= 720) {
        //    g.setColor(Color.BLACK);
         //   g.setFont(myFont1);
        //    g.drawString(gameovertext, 200, 360);

            birdyPOS = 720;
            this.add(restartBut);
            this.add(backToMenuBut);
            this.add(addscore);
        }
    }

        public void getNextTubeCord () {
        }

        public void changebirdcord () {
            birdA = -8;
        }

        public void dropbird () {
            birdA += birdI;
            birdV += birdA;
        }
        public void movetube () {
            tube -= tubeXValocity;
        }

        public void checkTubeCollusion ( int birdYPOS, int birdXPOS){

        }

    }

