package GUI;

import GUI.Enums.Phase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for rendering the game.
 */
public class Renderer extends JFrame {

    private JPanel container;

    /**
     * Tells renderer what to render currently.
     */
    private Phase phase = Phase.MAIN_MENU;


    private JPanel currentPanel;
    Renderer(JPanel initialPanel) {


        setTitle("BattleShip");
        setSize(1280, 720);

        currentPanel = initialPanel;

        //setContentPane(currentPanel);
        add(currentPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public  void Render( JPanel panel){
        remove(currentPanel);
        currentPanel = panel;
        add(currentPanel);
        validate();

    }


}
