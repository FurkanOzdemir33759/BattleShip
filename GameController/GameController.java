package GameController;

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

    /**
     * Updates the view.
     */
    public void updateView() {
        //TO DO
    }
}
