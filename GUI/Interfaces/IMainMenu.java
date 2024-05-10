package GUI.Interfaces;

/**
 * Provides the main menu user interface for the game.
 */
public interface IMainMenu {
    /**
     * Starts the game.
     */
    void startGame();

    /**
     * Allows access to game settings.
     */
    void accessSettings();

    /**
     * Exits the game.
     */
    void exitGame();
}