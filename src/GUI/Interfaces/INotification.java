package GUI.Interfaces;

/**
 * Manages notifications related to game events.
 */
public interface INotification {
    /**
     * Displays a notification when a hit occurs.
     */
    void displayHitMiss(boolean isHit);

    /**
     * Displays the results of the game.
     */
    void displayGameResults(String result);

}
