
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class MenuFundament extends JPanel{
    JButton but1, but2, but3, but4, but5, butscore;
    String titel;
    Image titelBB = new ImageIcon("/Users/uni/Desktop/BouncingBirdTitel.png").getImage();
    Image titelBwB = new ImageIcon("/Users/uni/Desktop/background_18.png").getImage();
    Image grünbird = new ImageIcon("/Users/uni/Desktop/GrünB.png").getImage();


    public MenuFundament() {

        setPreferredSize(new Dimension(438, 768));
        this.setLayout(null);
        //	this.setBackground(new Color(185, 220, 255));

        but1 = new JButton("Start Game");
        but2 = new JButton("Scoreboard");
        but3 = new JButton("Settings");
        but4 = new JButton("Rate Game");
        but5 = new JButton("Back to Menu");
        butscore = new JButton("Add Score");

        but1.addActionListener(new ButtonListener());
        but2.addActionListener(new ButtonListener());
        but3.addActionListener(new ButtonListener());
        but4.addActionListener(new ButtonListener());

        //	add(but1);
        //	add(but2);
        //	add(but3);
        //	add(but4);

        but1.setBounds(144, 250, 150, 50);
        but2.setBounds(144, 350, 150, 50);
        but3.setBounds(144, 450, 150, 50);
        but4.setBounds(144, 550, 150, 50);
        but5.setBounds(144, 350, 150, 50);

    }

    public void addtitel(String titel) {
        this.titel = titel;
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == but1) {
            }

            if (e.getSource() == but2) {
            }

            if (e.getSource() == but3) {
            }

            if (e.getSource() == but4) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.drawImage(titelBwB, 0, 0, 438, 768, this);


        //g.drawString("Designer: Majd, Ekber, David und Yasin", 100 , 738);

        repaint();

    }
}

