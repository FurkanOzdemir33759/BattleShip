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
    private JLabel gameStats = new JLabel();
    private JPanel boardPanel = new JPanel();
    private List<List<Square>> board;
    private Notification notification; // To display messages to the user

    public GameBoard() {
        this.board = new ArrayList<>();
        this.notification = new Notification();
        initializeBoard();
        setPreferredSize(new Dimension(600, 700));
        setLayout(new BorderLayout());


        boardPanel.setLayout(new GridLayout(10, 10));

        gameStats.setText("DUMMY TEXT!");
        gameStats.setPreferredSize(new Dimension(600, 100));
        add(gameStats, BorderLayout.NORTH);

        for (List<Square> row : board) {
            for (Square square : row) {
                boardPanel.add(square);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

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