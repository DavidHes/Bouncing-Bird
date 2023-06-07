import javax.swing.*;

    public class Gametester {
        public static void main(String[] args) {

            JFrame frame = new JFrame();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MenuPanel mp = new MenuPanel();
            GamePanel gpanel = new GamePanel();

            frame.getContentPane().add(gpanel);
            frame.pack();
            frame.setVisible(true);



        }
}
