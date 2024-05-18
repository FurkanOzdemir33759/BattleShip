package GUI.NEW;

import GameManager.Enums.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardView extends JPanel {
    private ArrayList<ArrayList<TileView>> grid = new ArrayList<>();
    private Player boardOwner;

    public BoardView(Player boardOwner) {

        this.boardOwner = boardOwner;


        setBackground(new Color(0X57A6A1));
        setAbsoluteSize(this, new Dimension(560, 560));
        setLayout(new GridLayout(10, 10));


        addGrid();
    }

    private void setAbsoluteSize(JComponent component, Dimension size) {
        component.setPreferredSize(size);
        component.setMaximumSize(size);
        component.setMinimumSize(size);
    }

    private void initializeGrid() {
        for (int i = 0; i < 10; i++) {
            ArrayList<TileView> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(new TileView(i,j, boardOwner));
            }
            grid.add(row);
        }
    }

    private void addGrid() {
        initializeGrid();
        for (ArrayList<TileView> tileViews : grid) {
            for (TileView tileView : tileViews) {
                add(tileView);
            }
        }
    }

    public JButton getTileButton(int x, int y) {
        return grid.get(x).get(y).getTileButton();
    }

    public void addActionListenerToTiles(ActionListener listener) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                getTileButton(i,j).addActionListener(listener);
            }
        }
    }

}
