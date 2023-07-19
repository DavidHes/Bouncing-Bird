import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GamePanel extends MenuBasis {
    int score = 0;
    int birdXpos = 75, birdYpos = 300;
    int birdV = 0, birdA = 8, birdI = 1; //birdA = Beschleunigung, birdV = Geschwidnigkeit
    final int tubeXValocity = 5, tubeWidth = 50;
    final int width = 700;
    int[] tube = {width, width + width / 2};
    int[] gap = {(int) (Math.random() * (frameHeight - 250)), (int) (Math.random() * (frameHeight - 250))};

    private final Font scoreFont = new Font("Serif", Font.BOLD, 28);
    private final Font clickToStartFont = new Font("Serif", Font.BOLD, 23);
    private final Font gameOverFont = new Font("Serif", Font.BOLD, 52);

    JButton restartBut, addScore;
    static boolean spielMenuVisible = false;
    static boolean gameOver = false;

    private boolean hasExecuted = false;

    String gameOverText = "Game Over";
    String clickToStartText = "Click with mouse or press Enter to Start!", clearClickToStartText = "";

    static String backgroundColor;

    JTextField scoreName ;
    private MouseListener mouseListener;
    private KeyListener keyListener;


    public GamePanel(GameController gameController, ActionListener actionListener) {
        super();
        this.gameController = gameController;
        this.addMouseListener(gameController);
        this.addKeyListener(gameController);
        this.setFocusable(true);

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);

        scoreName = new JTextField("Name.....");
        scoreName.setBounds(144, 350, 150, 45);
        scoreName.setEditable(true);
        scoreName.setVisible(true);
        scoreName.addActionListener(actionListener);
        add(scoreName);

        scoreName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (scoreName.getText().equals("Name.....")) {
                    scoreName.setText("");
                    scoreName.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (scoreName.getText().isEmpty()) {
                    scoreName.setText("Name.....");
                    scoreName.setForeground(Color.GRAY);
                }
            }

        });
        addScore = new JButton("Add Score");
        addScore.setBounds(144, 450, 150, 50);

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

        if (gameOver == false) {
            g.setColor(Color.BLACK);
            g.setFont(clickToStartFont);
            g.drawString(clickToStartText, 11, 400);
            spawnTube(g);
            drawbird(g);
            scoreName.setVisible(false);
            g.setColor(Color.BLACK);
            g.setFont(scoreFont);
            g.drawString("" + score, 205, 100);

            repaint();

        } else {
            g.setColor(Color.BLACK);
            g.setFont(scoreFont);
            g.drawString(clickToStartText, 11, 400);
            spawnTube(g);
            drawbird(g);
            g.setColor(Color.BLACK);
            g.setFont(scoreFont);
            g.drawString("" + score, 205, 100);

            repaint();
        }

        if(gameOver == true){
            g.setColor(Color.BLACK);
            g.setFont(gameOverFont);
            g.drawString(gameOverText, 88, 200);


            repaint();
        }
    }

//Überflüssig
    public void addController(GameController game) {
        this.gameController = game;
        addMouseListener(gameController);
        addKeyListener(gameController);

        setFocusable(true);
    }


    public void spawnTube(Graphics g) {
        for (int i = 0; i < 2; i++) {
            g.setColor(Color.RED);
            g.fillRect(tube[i], 0, tubeWidth, frameHeight);

            switch (backgroundColor) {
                case "Hintergrund-Stadt-Mittag.png":
                    g.setColor(new Color(147, 225, 254));
                    break;
                case "Hintergrund-Stadt-Nacht.png":
                    g.setColor(new Color(42, 89, 158));
                    break;
                case "Hintergrund-Stadt-Tag.png":
                    g.setColor(new Color(41, 183, 229));
                    break;
                default:
                    g.setColor(new Color(41, 183, 229));
                    break;
            }
            g.fillRect(tube[i], gap[i], tubeWidth, 100);

            //spawnt die neuen Tubes wenn ein Tube schwindet
            if (tube[i] + tubeWidth <= 0) {
                tube[i] = width;
                gap[i] = (int) (Math.random() * (frameHeight - 250));
            }
        }
    }

    public void gameOverBild() {
        ActionListener actionListener;

        this.add(restartBut);
        this.add(backToMenuBut);
        this.add(addScore);
        scoreName.setVisible(true);

        repaint();
        revalidate();

    }

    public void addTheScore() {

        String name = scoreName.getText();
        //vllt an der falschen Stelle
        //addscore(score,name);
        scoreName.setText("Name.....");
        scoreName.repaint();

    }

    public void restartTheGame() {


        clickToStartText = "Click with mouse or press Enter to Start!";
        score = 0;
        birdXpos = 75 ; birdYpos = 300;
        birdV = 0; birdA = 8; birdI = 1;
        tube [0] = width;
        tube [1] = width + width/2;
        gap [0] = (int) (Math.random() * (frameHeight - 250));
        gap [1] = (int) (Math.random() * (frameHeight - 250));
        gameOver = false;
        spielMenuVisible = false;
        scoreName.setText("Name.....");

        remove(backToMenuBut);
        remove(restartBut);
        remove(addScore);

        setFocusable(true);
        requestFocusInWindow();

        repaint();

    }

    public void drawbird(Graphics g) {

        g.drawImage(bird, birdXpos, birdYpos + birdV, 40, 40, this);
    }

    public void checkBorderCollusion() {
        System.out.println(birdYpos + birdV);

        if (!(birdYpos + birdV >= 0 && birdYpos + birdV + 40 <= frameHeight)) {
            System.out.println(birdYpos + " + " + frameHeight);
            //   System.out.println("Border getroffen");
            gameOver = true;
            spielMenuVisible = true;
            gameOverBild();
        }
    }

    public void changeBirdCord() {

        birdA = -8;
        System.out.println("haa");
    }

    public void dropBird() {
        if (clickToStartText == clearClickToStartText && gameOver == false) {
            birdA += birdI;
            birdV += birdA;
        }
    }

    public void moveTube() {
        if (clickToStartText == clearClickToStartText && gameOver == false) {
            tube[0] -= tubeXValocity;
            tube[1] -= tubeXValocity;
        }
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
                if ((birdYpos + birdV) >= 0 && (birdYpos + birdV) <= gap[i]
                        //or under gap
                        || (birdYpos + birdV + 40) >= gap[i] + 100 && (birdYpos + birdV + 40) <= frameHeight) {
                    gameOver = true;
                    GameController.gameStarted = false;
                    spielMenuVisible = true;
                    System.out.println("Tube getroffen");
                    gameOverBild();

                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
    }
}