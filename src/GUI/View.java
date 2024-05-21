package GUI;

import GameManager.GameManager;

import javax.swing.*;

public class View {
    /**
     * The game manager.
     */
    private GameManager manager;
    /**
     * The game board according to the board size given.
     */
    private GameBoard gameBoard;

    /**
     * The main menu of the game.
     */
    private MainMenu mainMenu;

    /**
     * The notification handler.
     */
    private Notification notification;

    /**
     * Renderer of all the above.
     */
    private Renderer renderer;

    /**
     * Constructor for the view.
     * @param manager The game manager.
     */
    public View(GameManager manager) {
        this.manager = manager;

        this.notification = new Notification();
        this.mainMenu = new MainMenu();
        this.gameBoard = new GameBoard();

        renderer = new Renderer(this.mainMenu);
    }

    public  void displayGameBoard(){
        renderer.Render(getGameBoard());

    }
    public  void displaySettings(){
        renderer.Render(getNotification());

    }

    public MainMenu getMainMenu() {return this.mainMenu;}
    public GameBoard getGameBoard() {return this.gameBoard;}
    public Notification getNotification() {return this.notification;}

    public void update(){
        //TO DO
    }
}
