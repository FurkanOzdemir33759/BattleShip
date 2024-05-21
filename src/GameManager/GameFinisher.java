package GameManager;

import GameManager.Interfaces.IGameFinisher;

/**
 * Represents a GameFinisher class that will finalize the game depending on the information passed to it.
 */
public class GameFinisher implements IGameFinisher {
    /**
     * Game result is stored in this attribute as a GameFinishInfo instance.
     */
    private final GameFinishInfo finishInfo;

    /**
     * Constructor for the GameFinisher object.
     * @param gameFinishInfo Holds the information necessary for finishing a game.
     */
    GameFinisher(GameFinishInfo gameFinishInfo) {
        this.finishInfo = gameFinishInfo;
    }

    /**
     * Finishes the game according to the gameFinishInfo given.
     * @param gameFinishInfo Container class that holds the information necessary for finishing a game.
     */
    public final void finishGame(GameFinishInfo gameFinishInfo) {
        // TO DO
    }

    /**
     * Finishes the game according to the finishInfo held by the current GameFinisher instance.
     */
    public void finishGame() {
        finishGame(finishInfo);
    }
}
