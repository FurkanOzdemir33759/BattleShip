package GameManager;

import GameManager.Interfaces.IGameProgression;

/**
 * This class manages the progression of the game.
 */
public class GameProgression implements IGameProgression {
    /**
     * Evaluates the current play.
     * @param playInfo The play info of the current turn.
     */
    public final void evaluatePlay(PlayInfo playInfo) {
        // TO DO
    }

    /**
     * Allows the player to attack.
     * @param x The x coordinate of the target.
     * @param y The y coordinate of the target.
     * @return Whether it was a hit or miss. Hit -> true, Miss -> false
     */
    public boolean attack(int x, int y) {
        //TO DO
        return true;
    }

    /**
     * Allows the player to place ships.
     * @param x The x coordinate of the target.
     * @param y The y coordinate of the target.
     * @return Whether the placement was successful or not.
     */
    public boolean place(int x, int y) {
        //TO DO
        return true;
    }

    /**
     * Signals that the turn has ended.
     */
    public void endTurn() {
        //TO DO
    }

}
