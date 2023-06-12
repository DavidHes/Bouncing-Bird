import javax.swing.*;

public class Gamerunner {
    public static void main(String[] args) {

        Gametesterneu game = new Gametesterneu();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.pack();
        game.setVisible(true);
    }
}
