package GameController;

import GUI.GameBoard;
import GameController.Interfaces.IGameStart;
import GameManager.GameStats;

/**
 * Handles the game start.
 */
public class GameStart implements IGameStart {
    /**
     * The starting game board.
     */
    private GameBoard initialGameBoard;

    /**
     * The starting game status.
     */
    private GameStats initialGameStats;
    /**
     * Getter for the game stats.
     * @return The game stats.
     */
    public final GameStats getGameStatus() {
        return initialGameStats;
    }

    /**
     * Getter for the game board.
     * @return The game board.
     */
    public final GameBoard getGameBoard() {
        return initialGameBoard;
    }

    /**
     * Updates the game manager and view.
     */
    public final void update() {
        //TO DO
    }
    public GameStart() {

    }
}
