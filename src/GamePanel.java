import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JPanel;
import javax.swing.Timer;

//import GUI.MyPanel.MoveListener;
//import GUI.MyPanel.MyMouseListener;
public class GamePanel extends MenuFundament{
    int score = 0;
    int birdxPOS = 100;
    int birdyPOS = 300;
    int inc = 70;
   private int drop = 5;
   private int gameoverdrop = 7;

    private Font myFont1 = new Font("Serif", Font.BOLD, 22);
   private Font myFont = new Font("Serif", Font.BOLD, 52);

    JButton startBut;
    JButton restartBut;

    boolean visible = true;
    boolean gameover = true;

    String gameovertext = "Game Over";
    String start = "Click to Start!";
    String St = "";

    Image tubeDown = new ImageIcon("/Users/uni/Desktop/tubeDown.png").getImage();
    Image tubeup = new ImageIcon("/Users/uni/Desktop/tube.png").getImage();

    Timer time;
    Timer myTimer = new Timer(10, new GameoverListener());

    public GamePanel() {

        time = new Timer(20, new MoveListener());


        butscore.setBounds(144, 350, 150, 50);
        but4.setBounds(144, 450, 150, 50);
        but5.setBounds(144, 550, 150, 50);

        startBut = new JButton("Start");
        startBut.setBounds(144, 250, 150, 50);

        restartBut = new JButton("Play Again");
        restartBut.setBounds(144, 250, 150, 50);


        startBut.addActionListener(new startgameListener());

        if (visible == true) {
            but4.setBounds(144, 350, 150, 50);
            but5.setBounds(144, 450, 150, 50);

            this.add(startBut);
            this.add(but4);
            this.add(but5);
        }

        this.addMouseListener(new MyMouseListener()); //new MyMouseListener() --> anaoynme innere Klasse, weil sie keinen Namen hat.

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

        if(visible == false) {
            g.setColor(Color.BLACK);
            g.setFont(myFont1);
            g.drawString(start, 150, 400);

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
                this.add(butscore);
                this.add(but4);
                this.add(but5);
            }

        }
        repaint();
    }

    public class startgameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == startBut) {
                gameover = false;
                visible = false;
            }

            if (visible == false) {

                remove(startBut);
                remove(but5);
                remove(but4);
                remove(butscore);
                repaint();
            }

            if(e.getSource() == but5) {

            }
        }
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {
            if(gameover == false) {
                start = St;
                birdyPOS = birdyPOS - inc;
                time.stop();
            }
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if(gameover == false) {
                time.start();
            }
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public class MoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            birdyPOS = birdyPOS + drop;
        }
    }

    public class GameoverListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            birdyPOS = birdyPOS + gameoverdrop;
        }
    }

}
