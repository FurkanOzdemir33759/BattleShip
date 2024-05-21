package GameManager;

import GameManager.Interfaces.IGameStarter;

/**
 * Represents a GameStarter class that will initialize the game depending on the information passed to it.
 */
public class GameStarter implements IGameStarter {

    /**
     * Game settings are stored in this attribute as a GameStartInfo instance.
     */
    private final GameStartInfo gameSettings;

    /**
     * Constructor for the GameStarter object.
     * @param gameSettings GameStartInfo instance that holds the game settings such as board size and opponent type.
     */
    GameStarter(GameStartInfo gameSettings) {
        this.gameSettings = gameSettings;
    }

    /**
     * Starts the game according to the gameSettings given.
     * @param gameSettings Holds the information necessary for starting a game.
     */
    public final void startGame(GameStartInfo gameSettings) {
        // TO DO
    }

    /**
     * Starts the game according to the gameSettings held by the current GameStarter instance.
     */
    public void startGame() {
        startGame(gameSettings);
    }
}
