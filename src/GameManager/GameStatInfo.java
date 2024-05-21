package GameManager;

/**
 * This class holds the game stats: Turn, scores, and current player.
 */
public class GameStatInfo {
    /**
     * The turn count. Even turns represent P1 and odd turns represent P2.
     */
    private final int turnCount;

    /**
     * Score of the first player.
     */
    private final int player1Score;

    /**
     * Score of the second player.
     */
    private final int player2Score;

    /**
     * The player that plays this turn. 0 => P1, 1 => P2
     */
    private final int currentPlayer;

    /**
     * Constructor to create a GameStatsInfo object.
     * @param currentTurn The current turn. Even turns represent P1 and odd turns represent P2.
     * @param player1Score The score of the first player.
     * @param player2Score The score of the second player.
     */
    GameStatInfo(int currentTurn, int player1Score, int player2Score) {
        turnCount = currentTurn;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        currentPlayer = turnCount % 2;
    }

    /**
     * Gets the current turn. Starts from 0.
     * @return The current turn.
     */
    public int getCurrentTurn() {
        return turnCount;
    }

    /**
     * Gets the score of the first player.
     * @return The score of the first player.
     */
    public int getPlayer1Score() {
        return player1Score;
    }

    /**
     * Gets the score of the second player.
     * @return The score of the second player.
     */
    public int getPlayer2Score() {
        return player2Score;
    }

    /**
     * Gets the current player as int. 0 => P1, 1 => P2
     * @return The current player as int.
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
