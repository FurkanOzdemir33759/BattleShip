package GameManager.Interfaces;

import GameManager.GameFinishInfo;

/**
 * This interface declares what a GameFinisher class must implement.
 */
public interface IGameFinisher {
    /**
     * Ends the game according to the finish information.
     * @param gameFinishInfo Container class that holds the information necessary for finishing a game.
     */
    public void finishGame(GameFinishInfo gameFinishInfo);
}
