package GameManager;

import GameManager.Enums.Phase;

/**
 * This class manages the progression of the game.
 */
public class GameProgression {
    private Phase gamePhase = Phase.SHIP_PLACEMENT;

    public GameProgression() {}

    public Phase getGamePhase() {
        return gamePhase;
    }

    public void nextPhase() {
        switch (gamePhase) {
            case SHIP_PLACEMENT -> gamePhase = gamePhase.PLAYER_ATTACK;
            case PLAYER_ATTACK -> gamePhase = Phase.AI_ATTACK;
            case AI_ATTACK -> gamePhase = Phase.PLAYER_ATTACK;
        }
    }

}
