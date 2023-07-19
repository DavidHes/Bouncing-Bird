import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends MenuBasis {

    SettingsList settingsList = new SettingsList();
    private JButton[] birdSkinButtons;
    private JButton[] backgroundButtons;
    private JButton selectedBirdButton;
    private JButton selectedBackgroundButton;

    /**
     * Der Konstruktor der Klasse ruft die beiden Hauptmethoden auf und sorgt durch den Aufruf der Klasse SettingsList
     * dafür, dass immer der aktuelleste Skin und Background angezeigt wird.
     * @param actionListener
     */
    public SettingsPanel(ActionListener actionListener) {
        super();
        initComponents();
        layoutComponents(actionListener);

        //SettingsPanel wird als Beobachter für die SettingsList registriert
        settingsList.addObserver(this);
        settingsList.getSkin();
        settingsList.getBackground();


    }

    /**
     * Die private Methode initComponents erzeugt zwei Arrays vom Typ JButton.
     * Durch die Hilfsmethode createImageButton wird jeder dieser sechs Buttons initialisiert
     */
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

    /** Diese private Methode ist für die Positionsfestsetzung der sechs Buttons sowie für die Positionsfestsetzung
     *  des Back-to-Menu-Buttons
     *
     * @param actionListener
     */
    private void layoutComponents(ActionListener actionListener) {
        setLayout(null); // Setzen des Layouts auf null, um die Position der Komponenten manuell festzulegen

        int x = 50; // X-Position der Buttons
        int y = 100; // Y-Position der Buttons
        int buttonWidth = 100; // Breite der Buttons
        int buttonHeight = 100; // Höhe der Buttons
        int horizontalGap = 125; // Horizontaler Abstand zwischen den Skin- und Backgroundbuttons

        for (int i = 0; i < 3; i++) {
            birdSkinButtons[i].setBounds(x, y, buttonWidth, buttonHeight);
            backgroundButtons[i].setBounds(x + buttonWidth + horizontalGap, y, buttonWidth, buttonHeight);

            add(birdSkinButtons[i]);
            add(backgroundButtons[i]);

            y += buttonHeight + 50; // Vertikaler Abstand zwischen den Buttons beträgt 50
        }

        backToMenuBut.setBounds(144, 650, 150, 50); // Position des BackToMenu-Buttons
        add(backToMenuBut);
        backToMenuBut.addActionListener(actionListener);
    }

    /**
     * Die private Methode createImageButton ist eine Hilfsmethode zum initialisieren der sechs Buttons
     * @param imageName ist der Name des Bildes bzw. des Buttons
     * @return der fertig initialisierte Button wird zurückgegeben
     */
    private JButton createImageButton(String imageName) {
        Image image = new ImageIcon(imageName).getImage();
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton button = new JButton(scaledIcon);

        button.setBorderPainted(false);
        button.setContentAreaFilled(false); //Füllt den Buttonhintergrund mit der jeweiligen Backgroundfarbe
        button.setName(imageName);

        button.addActionListener(new ImageSelectionListener());
        return button;
    }

    private class ImageSelectionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton clickedBirdButton = (JButton) event.getSource();
            JButton clickedBackgroundButton = (JButton) event.getSource();

            for (JButton birdButton : birdSkinButtons) {
                if (birdButton == clickedBirdButton) {
                    if (selectedBirdButton != null) {
                        selectedBirdButton.setBorderPainted(false); //Vorherige grüne Umrandung verschwindet
                    }
                    selectedBirdButton = birdButton;
                    birdButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    birdButton.setBorderPainted(true);
                    settingsList.setSkin("VOGELSKIN", selectedBirdButton.getName());

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

                    settingsList.getBackground();

                }
            }
        }
    }
}

