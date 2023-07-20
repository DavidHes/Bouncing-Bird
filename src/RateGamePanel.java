import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RateGamePanel extends MenuBasis {

    static RateGameList rateGameList = new RateGameList();
    static JLabel reviewLabel;
    static String reviews;


    public RateGamePanel(ActionListener actionListener) {
        super();

        setLayout(null);
        reviewLabel = new JLabel();
        reviewLabel.setBounds(10, 250, 2000, 50);
        add(reviewLabel);

        JButton writeReviewButton = new JButton("Click to rate");
        writeReviewButton.setBounds(144, 550, 150, 50);
        writeReviewButton.addActionListener(new ButtonClickListener());

        add(writeReviewButton);

        backToMenuBut.setBounds(144, 650, 150, 50);
        add(backToMenuBut);
        backToMenuBut.addActionListener(actionListener);

        rateGameList.addObserver(this);
        rateGameList.getRating();
    }

    private static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField commentTextField = new JTextField(10);
            JTextField userTextField = new JTextField(10);
            JComboBox<Integer> ratingComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));
            panel.add(new JLabel("Comment:"));
            panel.add(commentTextField);
            panel.add(new JLabel("User:"));
            panel.add(userTextField);
            panel.add(new JLabel("Rating:"));
            panel.add(ratingComboBox);

            int result = JOptionPane.showConfirmDialog(null, panel, "Write Review",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String comment = commentTextField.getText();
                String user = userTextField.getText();
                int rating = (int) ratingComboBox.getSelectedItem();

                if (!comment.isEmpty() && !user.isEmpty()) {
                    rateGameList.addRating(user, comment, rating);
                    rateGameList.getRating();
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus.",
                            "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
