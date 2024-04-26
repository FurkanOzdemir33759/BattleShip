package GameManager;

import GameManager.Enums.Player;

/**
 * This class holds the necessary information to finish a BattleShip game.
 */
public class GameFinishInfo {
    /**
     * Represents the winner of the game. P1 (0) for player1 and P2 (1) for player2 or AI.
     */
    private final int winner;

    /**
     * Represents the score of the winner.
     */
    private final int score;

    public GameFinishInfo(Player winner, int score) {
        this.winner = winner.ordinal();
        this.score = score;
    }
}
