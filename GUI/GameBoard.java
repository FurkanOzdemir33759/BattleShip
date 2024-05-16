package GUI;

import GUI.Interfaces.IGameBoard;

import javax.swing.*;
import java.util.List;

/**
 * Concrete class representing the game board.
 */
public class GameBoard extends JPanel implements IGameBoard {
    private List<List<Square>> board;
    private Notification notification; // To display messages to the user


    @Override
    public void placeShip(int x, int y, String orientation) {
        // Implementation code here
    }

    @Override
    public String receiveAttack(int x, int y) {
        return null;

    }
    public Square getSquare(int x, int y) {
        if (x >= 0 && x < board.size() && y >= 0 && y < board.get(x).size()) {
            return board.get(x).get(y);
        } else {
            notification.displayGameResults("Invalid coordinates: (" + x + ", " + y + ")");
            return null; // Return null for invalid coordinates
        }
    }


    public GameBoard() {
        add(new JLabel("GAME BOARD!"));
    }
}