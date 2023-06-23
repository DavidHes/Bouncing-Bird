import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

public class GamePanel extends MenuFundament {
    int score = 0;
    int birdxPOS = 75, birdyPOS = 300;
    int birdV = 0, birdA = 8, birdI = 1;
    final int tubeXValocity = 5, tubeWidth = 50;
    int [] tube = { width, width + width/2 };
    int [] gap = {(int) (Math.random() * (HEIGHT - 150)), (int) (Math.random() * (HEIGHT - 150))};

    // int jumpheight = 70;
    // private int drop = 5;
    //private int gameoverdrop = 7;
    private Font myFont1 = new Font("Serif", Font.BOLD, 22);
    private Font myFont = new Font("Serif", Font.BOLD, 52);

    JButton restartBut, addscore;
    boolean spielmenuvisible = false, gameover = false;
    String gameovertext = "Game Over";
    String clickToStartText = "Click with mouse or press Enter to Start!", clearClickToStartText = "";
    // Timer dropTimer = new Timer(20, new MoveListener());
    // Timer  gameOverDropTimer = new Timer(10, new GameoverListener());

  //  Image tubeDown = new ImageIcon("/Users/uni/Desktop/tubeDown.png").getImage();
   // Image tubeup = new ImageIcon("/Users/uni/Desktop/tube.png").getImage();

    public GamePanel() {

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);

        addscore = new JButton("Add Score");
        addscore.setBounds(144, 350, 150, 50);

        backToMenuBut.setBounds(144, 450, 150, 50);

        if(spielmenuvisible== true){
           this.gameoverbild();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        if(gameover == false) {

            g.setColor(Color.BLACK);
            g.setFont(myFont1);

            g.drawString(clickToStartText, 150, 400);
            g.drawString("" + score, 205, 100);

            drawbird(g);
            spawnTube(g);
        }
        if(gameover == true || spielmenuvisible == true){
            g.setFont(myFont1);
            g.drawString(gameovertext, 150, 400);

            g.setFont(myFont1);
            g.drawString("" + score, 205, 100);

            drawbird(g);
            spawnTube(g);
        }


    }

    public void addController(GameController game) {
        this.gameController = game;
        //restartBut.addActionListener(gameController);
        backToMenuBut.addActionListener(gameController);
        scoreBoardBut.addActionListener(gameController);

        // addscore.addActionListener(gameController);
    }

    public void spawnTube(Graphics g) {

        for(int i = 0; i < 2; i++) {
            g.setColor(Color.RED);
            g.fillRect(tube[i], 0, tubeWidth, height);

            g.setColor(new Color(90, 180, 224));
            g.fillRect(tube[i], gap[i], tubeWidth, 100);

            if(tube[i] + tubeWidth <= 0){
                tube[i] = width;
                gap[i] = (int) (Math.random() * (HEIGHT - 150));
            }
        }
    }

    public void gameoverbild() {

        this.add(restartBut);
        this.add(backToMenuBut);
        this.add(addscore);
    }
    public void restartTheGame() {

        String clickToStartText = "Click with mouse or press Enter to Start!";
     gameover = false;
     spielmenuvisible = false;

    }
    public void drawbird(Graphics g) {
        g.drawImage(grünbird, birdxPOS, birdyPOS + birdV, 25, 25, this);
    }

    public void checkBorderCollusion() {

        if(birdyPOS + birdV <= 0 || birdyPOS + birdV + 25 >= HEIGHT){
            gameover = true;
            spielmenuvisible = true;
        }
    }
    public void changebirdcord () {
        if(clickToStartText == clearClickToStartText && gameover == false) {
            birdA = -8;
        }
    }

    public void dropbird () {
        if(clickToStartText == clearClickToStartText && gameover == false) {
            birdA += birdI;
            birdV += birdA;
        }
    }
    public void movetube () {
      if(clickToStartText == clearClickToStartText && gameover == false) {
          tube[0] -= tubeXValocity;
          tube[1] -= tubeXValocity;
      }
    }

    public void startgame () {
        clickToStartText = clearClickToStartText;
    }
        public void checkTubeCollusion (){

        for(int i = 0; i < 2; i++){
            if(tube[i] <= 100 && tube[i] + tubeWidth >= 100 || tube[i] <= 75 && tube[i] + tubeWidth >= 75){
               if ((birdyPOS + birdV) >= 0 && (birdyPOS + birdV) <= gap[i]
                || (birdyPOS + birdV + 25) >= gap[i] + 100 && (birdyPOS + birdV + 25) <= HEIGHT) {
                   gameover = true;
                   spielmenuvisible = true;
               }
            }
        }
    }
}

