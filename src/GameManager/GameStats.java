package GameManager;

import GameManager.Interfaces.IGameStats;

/**
 * This class manages the game status.
 */
public class GameStats implements IGameStats {
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
     * Gets the status information.
     * @return The status information.
     */
    public final GameStatInfo getStatusInfo() {
        return statInfo;
    }

    /**
     * Gets the status as a GameStats instance.
     * @return The status.
     */
    public final GameStats getStatus() {
        return this;
    }

    /**
     * Sets the status according to the gameStatInfo passed.
     * @param nextGameStatus The new status.
     */
    public final void setStatus(GameStatInfo nextGameStatus) {
        statInfo = nextGameStatus;
    }
}
