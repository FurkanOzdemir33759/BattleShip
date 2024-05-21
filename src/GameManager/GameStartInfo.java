package GameManager;

/**
 *  This class holds the necessary information to start a BattleShip game.
 */
public class GameStartInfo {
    /**
     * Represents the size of the BattleShip board. BattleShip boards are always square.
     */
    private final int boardSize;

    /**
     * Represents whether the player is against another player or AI. True when playing against a player.
     */
    private final boolean isPlayerVsPlayer;

    /**
     * Constructor to create a GameStartInfo object with a board size and opponent specification.
     * @param boardSize The size of the board.
     * @param isPlayerVsPlayer The opponent specifier.
     *                         True when playing against another player.
     *                         False when playing against AI.
     */
    public GameStartInfo(int boardSize, boolean isPlayerVsPlayer) {
        this.boardSize = boardSize;
        this.isPlayerVsPlayer = isPlayerVsPlayer;
    }

    /**
     * Gets the board size.
     * @return The board size.
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * Gets the opponent specifier. Player opponent -> True, AI opponent -> False
     * @return The opponent specifier.
     */
    public boolean isAgainstPlayer() {
        return isPlayerVsPlayer;
    }

}
