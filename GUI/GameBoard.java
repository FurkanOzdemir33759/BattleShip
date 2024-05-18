package GUI;

import GUI.Interfaces.IGameBoard;
import GameManager.Enums.Orientation;
import GameManager.Ships.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Concrete class representing the game board.
 */
public class GameBoard extends JPanel implements IGameBoard {
    private JPanel shipSelectionPanel = new JPanel();
    private ArrayList<ShipSelectorButton> shipSelectionButtons = new ArrayList<>();
    private JLabel gameStats = new JLabel();
    private JPanel boardPanel = new JPanel();
    private List<List<Square>> board;
    private ShipObject selectedShip = null;
    private Notification notification; // To display messages to the user

    public GameBoard() {
        this.board = new ArrayList<>();
        this.notification = new Notification();
        initializeBoard();
        setLayout(new BorderLayout());


        boardPanel.setLayout(new GridLayout(10, 10));

        gameStats.setText("P1: Place Your Ships!");
        gameStats.setPreferredSize(new Dimension(600, 100));
        add(gameStats, BorderLayout.NORTH);


        shipSelectionPanel.setLayout(new GridLayout(5, 1));
        add(shipSelectionPanel, BorderLayout.WEST);
        addShipSelectionButtons();

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

    private class ShipNode extends JPanel {
        private ShipNode(Color shipColor) {
            setBackground(shipColor);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            setPreferredSize(new Dimension(30, 30));
            setMaximumSize(new Dimension(30, 30));
            setMinimumSize(new Dimension(30, 30));
        }
    }

    class ShipSelectorButton extends JPanel {
        private ShipObject shipObject;
        private JButton button;
        private JLabel counter;
        private int max_allowed;
        private int current_count;
        private JPanel shipDisplayer;

        JButton getButton() {
            return button;
        }

        private ShipSelectorButton(String buttonName, int max_allowed, ShipObject shipObject, Color shipColor) {
            this.shipObject = shipObject;

            setLayout(new FlowLayout());
            setPreferredSize(new Dimension(200, 100));

            shipDisplayer = new JPanel();
            button = new JButton(buttonName);
            current_count = 0;
            this.max_allowed = max_allowed;

            counter = new JLabel("" + (this.max_allowed - this.current_count));
            counter.setFont(new Font("Arial", Font.BOLD, 16));

            button.setPreferredSize(new Dimension(160, 50));

            add(button, BorderLayout.NORTH);
            add(counter, BorderLayout.CENTER);

            int col_count = shipObject.getShipLayoutForButton().size();

            shipDisplayer.setLayout(new GridLayout(1, col_count));

            for (int i = 0; i < col_count + 1; i++) {
                shipDisplayer.add(new ShipNode(shipColor));
            }

            add(shipDisplayer, BorderLayout.SOUTH);

            button.addActionListener(e -> {
                if (selectedShip == null) {
                    selectedShip = this.shipObject;
                    System.out.println("Selected ship " + this.shipObject.getName());
                } else {
                    // Notify the player that they have selected a ship already.
                }
            });
        }
    }

    private void addShipSelectionButtons() {
        shipSelectionButtons.add(new ShipSelectorButton("Aircraft Carrier", 1, new Carrier(0, 0, Orientation.RIGHT), Color.RED));
        shipSelectionButtons.add(new ShipSelectorButton("Battleship", 1, new Battleship(0, 0, Orientation.RIGHT), Color.PINK));
        shipSelectionButtons.add(new ShipSelectorButton("Cruiser", 2, new Cruiser(0, 0 , Orientation.RIGHT), Color.ORANGE));
        shipSelectionButtons.add(new ShipSelectorButton("Destroyer", 2, new Destroyer(0, 0, Orientation.RIGHT), Color.yellow));
        shipSelectionButtons.add(new ShipSelectorButton("Boat", 3, new Boat(0, 0, Orientation.RIGHT), Color.lightGray));

        for (ShipSelectorButton button : shipSelectionButtons) {
            shipSelectionPanel.add(button);
        }
    }



}