package GameController;

import GUI.GameBoard;
import GUI.MainMenu;
import GUI.Notification;
import GameManager.GameManager;
import GUI.View;

/**
 * The controller class of the game.
 */
public class GameController {
    /**
     * The manager of the game.
     */
    private GameManager manager;
    private MainMenu mainMenu;
    private GameBoard gameBoard;
    private Notification notification;
    private boolean itsPlayersTurn;


    /**
     * The view of the game.
     */
    private View view;

    /**
     * Constructor for the GameController
     * @param manager The game manager (model).
     * @param view The game view.
     */
    public GameController(GameManager manager, View view) {
        this.manager = manager;
        this.view = view;
        this.itsPlayersTurn = true;
        this.mainMenu = new MainMenu();
        this.gameBoard = new GameBoard();
        this.notification = new Notification();
    }

    /**
     * Gets the active game manager from outside and sets the game manager accordingly.
     * @param manager The active game manager.
     */
    public void getGameManager(GameManager manager) {
        this.manager = manager;
    }

    /**
     * Gets the active view from outside and sets the view accordingly.
     * @param view The active view.
     */
    public void getView(View view) {
        this.view = view;
    }

    /**
     * Updates the manager.
     */
    public void updateManager() {
        //TO DO
    }
    /*
    Game starts by showing the main menu and sets the game board.
     */
    public void startGame(){
       if(mainMenu != null){
           mainMenu.show();
       }
       setupGameBoard();
       showNotification("Welcome to Battleship!");
    }
    /*
    Game board set to be played.
     */
    private void setupGameBoard(){
        this.gameBoard = new GameBoard();

    }
    /*
    Notification method
     */
    private void showNotification(String message){
        if(notification !=null){
            System.out.println(message);
        }
    }

    /**
     * Updates the view.
     */
    public void updateView() {
        //TO DO

    }
}
