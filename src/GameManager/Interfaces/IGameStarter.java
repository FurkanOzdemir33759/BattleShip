package GameManager.Interfaces;

import GameManager.GameStartInfo;

/**
 * This interface declares what a GameStarter class must implement.
 */
public interface IGameStarter {

    /**
     * Starts the game according to start information.
     * @param gameStartInfo Container class that holds the information necessary for starting a game.
     */
    void startGame(GameStartInfo gameStartInfo);
}
