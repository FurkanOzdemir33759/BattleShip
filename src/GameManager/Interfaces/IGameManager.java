package GameManager.Interfaces;

/**
 * This interface declares what a GameManager class must implement.
 */
public interface IGameManager {
    /**
     * Initializes the game according to the GameStarter.
     */
    public void initGame();

    /**
     * Updates the game according to the GameProgression.
     */
    public void update();

    /**
     * Ends the game according to the GameFinisher
     */
    public void endGame();
}
