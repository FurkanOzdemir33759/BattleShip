package GameManager;

import GameManager.Interfaces.IGameProgression;
import GUI.GameBoard;
import GUI.Notification;
import GUI.Square;


/**
 * This class manages the progression of the game.
 */
public class GameProgression implements IGameProgression {
    private GameBoard gameBoard;
    private Notification notification;
    private boolean playerTurn;

    public GameProgression(GameBoard gameBoard, Notification notification) {
        this.gameBoard = gameBoard;
        this.notification = notification;
        this.playerTurn = true;
    }

    /**
     * Evaluates the current play.
     * @param playInfo The play info of the current turn.
     */
    public final void evaluatePlay(PlayInfo playInfo) {
        boolean hit = attack(playInfo.getX(), playInfo.getY());
        if (hit) {
            notification.displayHitMiss(true); // Hit
        } else {
            notification.displayHitMiss(false); // Miss
        }
        endTurn();    }

    /**
     * Allows the player to attack.
     * @param x The x coordinate of the target.
     * @param y The y coordinate of the target.
     * @return Whether it was a hit or miss. Hit -> true, Miss -> false
     */
    public boolean attack(int x, int y) {
        Square targetSquare = gameBoard.getSquare(x, y);
        if (targetSquare.isHit()) {
            notification.displayHitMiss(false); // Already attacked, treated as a miss for feedback
            return false;
        }
        targetSquare.setHit(true);
        if (targetSquare.isOccupied()) {
            notification.displayHitMiss(true); // Hit
            return true;
        } else {
            notification.displayHitMiss(false); // Miss
            return false;
        }
    }

    /**
     * Allows the player to place ships.
     * @param x The x coordinate of the target.
     * @param y The y coordinate of the target.
     * @return Whether the placement was successful or not.
     */
    public boolean place(int x, int y) {
        Square targetSquare = gameBoard.getSquare(x, y);
        if (targetSquare == null || targetSquare.isOccupied()) {
            notification.displayGameResults("There is already a ship here."); // Placement failed
            return false;
        }
        targetSquare.setOccupied(true);
        return true;
    }

    /**
     * Signals that the turn has ended.
     */
    public void endTurn() {
        playerTurn = !playerTurn; // Turn ends, switch player
        notification.displayGameResults(playerTurn ? "Player's turn" : "AI's turn");    }

}
