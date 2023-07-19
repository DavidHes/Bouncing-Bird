import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GamePanel extends MenuBasis {
    int score = 0;
    int birdXpos = 75, birdYpos = 300;
    int birdV = 0, birdA = 8, birdG = 1;
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
    String gameOverText = "Game Over";
    String clickToStartText = "Click with mouse or press Enter to Start!", clearClickToStartText = "";
    static String backgroundColor;
    JTextField scoreName ;

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

        /**
         * Ein FocusListener(Interface) kann an ein GUI-Element angehängt werden, um auf Ereignisse zu reagieren,
         * wenn das Element den Fokus erhält oder verliert. Der FocusListener definiert zwei Methoden:
         * void focusGained(FocusEvent e): Diese Methode wird aufgerufen, wenn das Element den Fokus erhält.
         * void focusLost(FocusEvent e): Diese Methode wird aufgerufen, wenn das Element den Fokus verliert.
         */
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

    /**
     * Diese Methode wird aufgrerufen, um das bildschirm nach dem ersten Gameclick von dem string clickToStartText
     * zu clearen.
     */
    public void startgame() {
        clickToStartText = clearClickToStartText;
        repaint();
    }

    /**
     * Bemalt den Panel mit Elemente wie z.B. Bird, Tube, Gameovertext und so weiter
     * @param g the <code>Graphics</code> object to protect
     */
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

    /**
     * rendert die Tubes mit den gaps, aus den beiden Arrays. Verwendet wird eine For-Schleife,
     * um die Werte der Beiden Arrays tube und gap auszugeben. mit g.setColor(); legen wir die
     * Farbe der Tubes und gaps an und mit g.fillRect() rendern wir die gaps und tube.
     * switch-Anweisung benutzen wir, um zu überprüfen welcher Hintegrund vom Nutzer ausgewählt wurde
     * und für jeden Hintergrund haben wir für die gaps eine andere farbe.
     * @param g
     */
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
            /**
             * restet die x-Position von dem Tube, wenn der Tube aus dem Bildschirm verschwindet
             */
            if (tube[i] + tubeWidth <= 0) {
                tube[i] = width;
                gap[i] = (int) (Math.random() * (frameHeight - 250));
            } } }

    /**
     * Diese Methode wird aufgerufen, wenn der Spieler verliert und
     * mit dieser Methode adden wir unsere Buttons restartBut,backToMenuBut,addScore zum
     * zu unserem Panel und zeigen unseren JTextfield scorename an.
     */
    public void gameOverBild() {
        ActionListener actionListener;

        this.add(restartBut);
        this.add(backToMenuBut);
        this.add(addScore);
        scoreName.setVisible(true);

        repaint();
        revalidate();

    }

    /**
     * Diese Methode wird mit dem button click addscore in dem Gamecontroller aufgerufen
     * und diese ermöglicht, die Speicherung des neuen Scores in die Datenbank.
     */
    public void addTheScore() {

        String name = scoreName.getText();
        //vllt an der falschen Stelle
        //addscore(score,name);
        scoreName.setText("Name.....");
        scoreName.repaint();

    }

    /**
     * Diese Methode restet alle möglichen Attribute die wir brauchen,damit der Spieler mit play again
     * ganz normal wieder spielen kann.
     */
    public void restartTheGame() {

        clickToStartText = "Click with mouse or press Enter to Start!";
        score = 0;
        birdXpos = 75 ; birdYpos = 300;
        birdV = 0; birdA = 8; birdG = 1;
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

    /**
     * Bemalt unseren Panel mit dem einem Bild von dem Vogel
     * @param g
     */
    public void drawbird(Graphics g) {
        g.drawImage(bird, birdXpos, birdYpos + birdV, 40, 40, this);
    }

    /**
     * Hier wird überprüft, ob der Vogel den Boden oder die obere Kante vom Panel trifft.
     * Mit der if-Anweisung fragen wir ob die Vogel Position unter 0 oder über dem frameheight ist
     * Falls das der fall ist, dann werden gameOver und spielMenuVisible auf true gesetzt und
     * mit gameOverBild(); blendet man den gameoverbild ein.
     */
    public void checkBorderCollusion() {
        System.out.println(birdYpos + birdV);

        if (!(birdYpos + birdV >= 0 && birdYpos + birdV + 40 <= frameHeight)) {
            System.out.println(birdYpos + " + " + frameHeight);
            gameOver = true;
            spielMenuVisible = true;
            gameOverBild();
        }
    }

    /**
     * Mit Space oder mouse click wird diese Methode aufgerufen und sie sorgt, dafüt dass dier Y-Pos
     * vom vogel sich ändert und zwar, dass der Vogel nach oben fliegt. Sie setzt BirdA auf -8,
     * zuvor war BirdA auf 8. Wie das passiert, sieht man in der Methode dropBird().
     */
    public void changeBirdCord() {
        birdA = -8;
        System.out.println("haa");
    }

    /**
     * Diese Methode wird aufgerufen, damit der Vogel nach unten fliegt, wenn der Benutzer,
     * Space oder mit der Mouse nicht clickt. Nach jedem Aufruf drop der Vogel weiter nach unten.
     * BirdG steht für birdgravity dieser Wert wird bei jedem Aufruf dieser Methode zu birdA (acceleration)
     * geaddet. und BirdA wird dann zu BirdV(Velocity, deutsch: Geschwindigkeit) geaddet und BirdV ändert
     * DANN die Y-Pos des Vogels.
     *
     */
    public void dropBird() {
        if (clickToStartText == clearClickToStartText && gameOver == false) {
            birdA += birdG;
            birdV += birdA;
        }
    }

    /**
     * Diese Methode sorgt dafür, dass die Tubes Positionen, sich ändern (Position kleiner wird).
     */
    public void moveTube() {
        if (clickToStartText == clearClickToStartText && gameOver == false) {
            tube[0] -= tubeXValocity;
            tube[1] -= tubeXValocity;
        }
    }

    /**
     * Aktualisiert den Score, um 1, wenn der Tube hinter dem Vogel ist.
     */
    public void updateScore() {
        for (int i = 0; i < 2; i++) {
            if(75 == tube[i] + tubeWidth) {
                score++;
            }
        }
    }

    /**
     * Überprüft ob der Vogel gegen ein Tube gestoßen ist oder nicht.
     */
    public void checkTubeCollusion() {

        for (int i = 0; i < 2; i++) {
            /**
             *  if tube in front bird and bird is in gap OR tube behind bird and bird is in gap.
             */
            if (tube[i] <= 115 && tube[i] + tubeWidth >= 115 || tube[i] <= 75 && tube[i] + tubeWidth >= 75) {
                /**
                 * if bird is over gap
                 */
                if ((birdYpos + birdV) <= gap[i]
                        /**
                         * or under gap
                         */
                        || (birdYpos + birdV + 40) >= gap[i] + 100) {
                    gameOver = true;
                    GameController.gameStarted = false;
                    spielMenuVisible = true;
                    System.out.println("Tube getroffen");
                    gameOverBild();
                }
            }
        }
    }

}