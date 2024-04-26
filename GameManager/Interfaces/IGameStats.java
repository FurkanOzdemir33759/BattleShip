package GameManager.Interfaces;

import GameManager.GameStatInfo;
import GameManager.GameStats;

/**
 * This interface declares what a GameStats class must implement.
 */
public interface IGameStats {
    /**
     * Sets the status according to the gameStatInfo passed.
     * @param gameStatInfo The new status.
     */
    void setStatus(GameStatInfo gameStatInfo);

    /**
     * Gets the status as a GameStats instance.
     * @return The status.
     */
    GameStats getStatus();

    /**
     * Gets the status information.
     * @return The status information.
     */
    GameStatInfo getStatusInfo();
}
