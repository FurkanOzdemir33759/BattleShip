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


}
