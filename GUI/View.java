package GUI;

import GameManager.GameManager;

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
        renderer = new Renderer();
    }

    /**
     * Sets the game board according to the game manager configuration.
     */
    private void setGameBoard() {
        //TO DO
        this.gameBoard = new GameBoard();
    }

    private void setMainMenu() {
        //TO DO
        this.mainMenu = new MainMenu();
    }

    private void setNotification() {
        //TO DO
        this.notification = new Notification();
    }
    public void update(){
        //TO DO
    }
}
