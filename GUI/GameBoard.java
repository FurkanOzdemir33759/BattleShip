package GUI;

import GUI.Interfaces.IGameBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete class representing the game board.
 */
public class GameBoard extends JPanel implements IGameBoard {
    private List<List<Square>> board;
    private Notification notification; // To display messages to the user

    public GameBoard() {
        this.board = new ArrayList<>();
        this.notification = new Notification();
        initializeBoard();
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(10, 10));
        for (List<Square> row : board) {
            for (Square square : row) {
                add(square);
            }
        }
        add(new JLabel("GAME BOARD!"));
    }
    private void initializeBoard() {
        for (int i = 0; i < 10; i++) {
            List<Square> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(new Square(i, j));
            }
            board.add(row);
        }
    }
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



}