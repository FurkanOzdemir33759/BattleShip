package GUI.Interfaces;

/**
 * Manages notifications related to game events.
 */
public interface INotification {
    /**
     * Displays a notification when a hit occurs.
     */
    public void displayHitMiss();

    /**
     * Displays the results of the game.
     */
    public void displayGameResults();
}
