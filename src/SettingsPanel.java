import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class SettingsPanel extends MenuFundament {

    SettingsList settingsList = new SettingsList();
    private JButton[] birdSkinButtons;
    private JButton[] backgroundButtons;
    private JButton selectedBirdButton;
    private JButton selectedBackgroundButton;

    public SettingsPanel(ActionListener actionListener) {
        super();
        initComponents();
        layoutComponents(actionListener);

        titelBwB = new ImageIcon(settingsList.getBackground()).getImage();
       // grünbird = new ImageIcon(settingsList.getSkin()).getImage();
        GamePanel.BackgroundColor = settingsList.getBackground();

        settingsList.addObserver(this);


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

    }

    private void layoutComponents(ActionListener actionListener) {
        setLayout(null); // Setzen Sie das Layout auf null, um die Position der Komponenten manuell festzulegen

        int x = 50; // X-Position der Buttons
        int y = 100; // Y-Position der Buttons
        int buttonWidth = 100; // Breite der Buttons
        int buttonHeight = 100; // Höhe der Buttons
        int horizontalGap = 100; // Horizontaler Abstand zwischen den Buttons

        for (int i = 0; i < 3; i++) {
            birdSkinButtons[i].setBounds(x, y, buttonWidth, buttonHeight);
            backgroundButtons[i].setBounds(x + buttonWidth + horizontalGap, y, buttonWidth, buttonHeight);

            add(birdSkinButtons[i]);
            add(backgroundButtons[i]);

            y += buttonHeight + 50; // Vertikaler Abstand zwischen den Buttons
        }

        backToMenuBut.setBounds(144, 650, 150, 50); // Position des BackToMenu-Buttons
        add(backToMenuBut);
        backToMenuBut.addActionListener(actionListener);
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

   /* private void checkAuswahl() {
        if(settingsList.getSkin() != null) {
            System.out.println("nicht leer");

        } else {
            System.out.println("leer");
        }
    }
*/
    private class ImageSelectionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton clickedBirdButton = (JButton) event.getSource();
            JButton clickedBackgroundButton = (JButton) event.getSource();

            for (JButton birdButton : birdSkinButtons) {
                if (birdButton == clickedBirdButton) {
                    if (selectedBirdButton != null) {
                        selectedBirdButton.setBorderPainted(false);
                    }
                    selectedBirdButton = birdButton;
                    birdButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    birdButton.setBorderPainted(true);
                    System.out.println("In Settingspanel ist folgender Button der selectedBIRDButton: " + selectedBirdButton.getName());
                    settingsList.setSkin("VOGELSKIN", selectedBirdButton.getName());
                    //System.out.println("Neuster Eintrag Skin: " + settingsList.getSkin());

                   // grünbird = new ImageIcon(settingsList.getSkin()).getImage();
                    settingsList.getSkin();



                }
            }

            for (JButton backgroundButton : backgroundButtons) {
                if (backgroundButton == clickedBackgroundButton) {
                    if (selectedBackgroundButton != null) {
                        selectedBackgroundButton.setBorderPainted(false);
                    }
                    selectedBackgroundButton = backgroundButton;
                    backgroundButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                    backgroundButton.setBorderPainted(true);
                    System.out.println("In Settingspanel ist folgender Button der selectedBACKGROUNDButton: " + selectedBackgroundButton.getName());
                    settingsList.setBackground("HINTERGRUND", selectedBackgroundButton.getName());
                    System.out.println("Neuster Eintrag Background: " + settingsList.getBackground());

                    titelBwB = new ImageIcon(settingsList.getBackground()).getImage();
                    GamePanel.BackgroundColor = settingsList.getBackground(); //Gleichzeitig muss für hier die
                    // BackgroundColor für GamePanel festgelegt werden (für die Mitte der Tubes).




                }
            }

          /*  JButton selectedDBBirdButton = (JButton) event.getSource();
            if (selectedBirdButton != null) {
                System.out.println("In Settingspanel ist folgender Button der selectedBIRDButton: " + selectedDBBirdButton.getName());
                settingsList.setSkin("VOGELSKIN", selectedBirdButton.getName());
                selectedDBBirdButton

            }
            JButton selectedDBBackgroundButton = (JButton) event.getSource();
            if (selectedBackgroundButton != null) {
                System.out.println("In Settingspanel ist folgender Button der selectedBACKGROUNDButton: " + selectedDBBackgroundButton.getName());
                settingsList.setBackground("HINTERGRUND", selectedBackgroundButton.getName());
            }
        }*/
        }

        public void update(Observable o, Object arg) {

        }

    }
}

