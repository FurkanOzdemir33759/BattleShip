package GameController.Interfaces;

import GUI.GameBoard;
import GameManager.GameStats;

/**
 * This interface declares what a GameStart class must implement.
 */
public interface IGameStart {
    /**
     * Getter for the game status.
     * @return The game stats.
     */
    public GameStats getGameStatus();

    /**
     * Getter for the game board.
     * @return The game board.
     */
    public GameBoard getGameBoard();

    /**
     * Updates the game model and view.
     */
    public void update();

}
