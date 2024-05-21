package GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private JButton playButton;
    private JButton exitButton;
    public MainMenu() {

        setBackground(GUI_PALETTE.BACKGROUND);
        setLayout(null);
        JLabel gameName = new JLabel("BATTLESHIP");
        GUI_Util.placeAbsoluteComponent(gameName, 440, 100, 400, 100);
        gameName.setHorizontalAlignment(SwingConstants.CENTER);
        gameName.setVerticalAlignment(SwingConstants.CENTER);
        gameName.setFont(new Font("Monospaced", Font.ITALIC, 50));
        gameName.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);

        playButton = new JButton("PLAY");
        GUI_Util.placeAbsoluteComponent(playButton, 10, 300, 1240, 100);
        GUI_Util.alterButtonLook(playButton);


        exitButton = new JButton("QUIT");
        GUI_Util.alterButtonLook(exitButton);
        GUI_Util.placeAbsoluteComponent(exitButton, 10, 410, 1240, 100);

        JLabel tutorial1 = new JLabel("<html><div style='text-align: center;'>DRAG THE SHIPS AROUND TO SET THE BOARD.<br>PRESS 'R' TO ROTATE THE SELECTED SHIP.<br>DESTROY YOUR OPPONENT'S SHIPS BY CLICKING ON THEIR BOARD.</div></html>");
        tutorial1.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);
        tutorial1.setHorizontalAlignment(SwingConstants.CENTER);
        tutorial1.setVerticalAlignment(SwingConstants.CENTER);
        tutorial1.setFont(new Font("SansSerif", Font.ITALIC, 18));
        GUI_Util.placeAbsoluteComponent(tutorial1, 240, 520, 800, 200);

        add(gameName);
        add(playButton);
        add(exitButton);
        add(tutorial1);
    }

    public JButton getStartButton() {
        return playButton;
    }
    public JButton getExitButton(){
        return exitButton;
    }
}
