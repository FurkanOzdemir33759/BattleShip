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
    private CardLayout cardLayout;
    private JPanel container;

    /**
     * Tells renderer what to render currently.
     */
    private Phase phase = Phase.MAIN_MENU;

    /**
     * The main menu to be rendered when the application starts.
     */
    private MainMenu mainMenu;

    /**
     * The game board to be rendered when the game begins.
     */
    private GameBoard gameBoard;

    /**
     * Notifications to show during the game.
     */
    private Notification notification;
    Renderer() {
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        mainMenu = new MainMenu();
        gameBoard = new GameBoard();
        notification = new Notification();

        setTitle("BattleShip");
        setSize(1280, 720);

        add(container);

        container.add(mainMenu, "mainMenu");
        container.add(gameBoard, "gameBoard");
        container.add(notification, "notification");

        JButton next = new JButton("next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(container);
            }
        });
        add(next, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void renderer(GameBoard gameBoard, MainMenu mainMenu, Notification notification){
        //TO DO
    }

    void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }


}
