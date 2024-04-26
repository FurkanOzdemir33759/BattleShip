package GameManager;

/**
 * This class manages the game status.
 */
public class GameStats {
    /**
     * Represents the information about the game status.
     */
    private GameStatInfo statInfo;

    /**
     * Default constructor of the GameStats.
     */
    GameStats() {
        statInfo = null;
    }

    /**
     * Gets the game status.
     * @return The game status.
     */
    public GameStatInfo getStatus() {
        return statInfo;
    }

    /**
     * Sets the game status.
     * @param nextGameStatus The next game status as GameStatInfo instance.
     */
    public void setStatus(GameStatInfo nextGameStatus) {
        statInfo = nextGameStatus;
    }
}
