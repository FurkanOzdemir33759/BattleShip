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

    /**
     * Constructor for the GameFinishInfo. Takes a winner and a score.
     * @param winner The winner. 0 for player one, 1 for player two or AI.
     * @param score The score of the winner.
     */
    public GameFinishInfo(int winner, int score) {
        this.winner = winner;
        this.score = score;
    }

    /**
     * Constructor for the GameFinishInfo. Takes a winner enum and a score.
     * @param winner The winner. P1 for player one, P2 for player two or AI.
     * @param score The score of the winner.
     */
    public GameFinishInfo(Player winner, int score) {
        this(winner.ordinal(),  score);
    }

    /**
     * Gets the winner as int. 0 => P1, 1 => P2/AI
     * @return The winner as int.
     */
    public int getWinner() {
        return winner;
    }

    /**
     * Gets the winner as enum. P1 => 0, P2 => 1
     * @return The winner as enum.
     */
    public Player getWinnerAsEnum() throws IllegalArgumentException {
        return switch (winner) {
            case 0 -> Player.PLAYER;
            case 1 -> Player.AI;
            default -> throw new IllegalArgumentException("Invalid winner number: " + winner);
        };
    }

    /**
     * Gets the score of the winner.
     * @return The score of the winner.
     */
    public int getScore() {
        return score;
    }
}
