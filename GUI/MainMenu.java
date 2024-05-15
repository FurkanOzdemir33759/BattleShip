package GUI;

import GUI.Interfaces.IMainMenu;


import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel implements IMainMenu {





    @Override
    public void startGame() {
        // Implementation code here


    }

    @Override
    public void accessSettings() {
        // Implementation code here

    }

    @Override
    public void exitGame() {
        // Implementation code here

    }

    public MainMenu() {
        setLayout(null);
        JLabel gameName = new JLabel("BATTLESHIP ");
        gameName.setFont(new Font("Georgia",Font.BOLD,40));
        gameName.setBounds(500,50,300,150);

        JButton playButton = new JButton("PLAY");
        playButton.setFont(new Font("Georgia", Font.PLAIN,20));
        playButton.setBounds(540,200,200,50);

        JButton settingsButton = new JButton("SETTINGS");
        settingsButton.setFont(new Font("Georgia",Font.PLAIN,20));
        settingsButton.setBounds(540,300,200,50);

        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Georgia", Font.PLAIN,20));
        exitButton.setBounds(540,400,200,50);




        add(gameName);
        add(playButton);
        add(settingsButton);
        add(exitButton);





    }

}
