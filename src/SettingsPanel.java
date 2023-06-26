import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SettingsPanel extends MenuFundament {

    private JButton[] birdSkinButtons;
    private JButton[] backgroundButtons;
    private JButton applyButton;
    private JButton selectedBirdButton;
    private JButton selectedBackgroundButton;

    public SettingsPanel(ActionListener actionListener) {

        super();
        add(backToMenuBut);
        backToMenuBut.addActionListener(actionListener);

        initComponents();
        layoutComponents();

    }

    private void initComponents() {

        birdSkinButtons = new JButton[3];
        birdSkinButtons[0] = createImageButton("Vogel-Blau.png");
        birdSkinButtons[1] = createImageButton("Vogel-Braun.png");
        birdSkinButtons[2] = createImageButton("Vogel-Grün.png");

        backgroundButtons = new JButton[3];
        backgroundButtons[0] = createImageButton("Hintergrund-Stadt-Tag.png");
        backgroundButtons[1] = createImageButton("Hintergrund-Stadt-Mittag.png");
        backgroundButtons[2] = createImageButton("Hintergrund-Stadt-Nacht.png");

        applyButton = new JButton("Speichern");

    }

    private void layoutComponents() {
        setLayout(new GridLayout(0, 2)); // 0 Zeilen, 2 Spalten

        add(birdSkinButtons[0]);
        add(backgroundButtons[0]);

        add(birdSkinButtons[1]);
        add(backgroundButtons[1]);

        add(birdSkinButtons[2]);
        add(backgroundButtons[2]);

    }

    private JButton createImageButton(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton button = new JButton(scaledIcon);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setName(imagePath);
        button.addActionListener(new ImageSelectionListener());
        return button;
    }

    /*private void applyChanges() {
        if (selectedButton != null) {
            try {
                FileWriter writer = new FileWriter("Settings.txt", false); //false sorgt dafür, dass die txt überschrieben wird

                writer.write("Skin: " + selectedButton.getName() + "\n");
                writer.write("Background: " + selectedButton.getName()+ "\n");
                System.out.println("Hallo neues Bild: " + selectedButton.getName());
                writer.close();

            } catch (IOException e) {
                System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
            }
            //JOptionPane.showMessageDialog(frame, "Änderungen wurden erfolgreich gespeichert!");
        }
    }

     */

    private class ImageSelectionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton clickedButton = (JButton) event.getSource();

            for (JButton birdButton : birdSkinButtons) {
                if (birdButton == clickedButton) {
                    selectedBirdButton = clickedButton;
                }
            }

            for (JButton backgroundButton : backgroundButtons) {
                if (backgroundButton == clickedButton) {
                    selectedBackgroundButton = clickedButton;
                }
            }

            JButton selectedButton = (JButton) event.getSource();

            try {
                FileWriter writer = new FileWriter("Settings.txt", false); //false sorgt dafür, dass die txt überschrieben wird

                if (selectedBirdButton != null) {
                    writer.write("Skin: " + selectedBirdButton.getName() + "\n");
                }

                if (selectedBackgroundButton != null) {
                    writer.write("Background: " + selectedBackgroundButton.getName() + "\n");
                }

                writer.close();

            } catch (IOException exception) {
                System.out.println("Fehler beim Schreiben der Datei: " + exception.getMessage());
            }
        }
    }
}

