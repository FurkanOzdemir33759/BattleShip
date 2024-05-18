package GUI.NEW;

import GUI.Enums.PALETTE;
import GameManager.Enums.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TileView extends JPanel {
    private int x;
    private int y;
    private Player tileOwner;
    private boolean isRevealed = false;
    private boolean isEmpty = false;
    private Color color = null;
    private JButton tileButton = new JButton();

    public TileView(int x, int y, Player tileOwner) {

        this.x = x;
        this.y = y;
        this.tileOwner = tileOwner;


        setLayout(new GridLayout());
        adjustColor();
        adjustBorder();


        add(tileButton);
    }

    private void adjustColor() {
        if (!isRevealed) {
            tileButton.setBackground(PALETTE.WATER);
        } else {
            if (isEmpty) {
                tileButton.setBackground(new Color(0X32012F));
            } else {
                tileButton.setBackground(new Color(0XFF5F00));
            }
        }
    }

    private void adjustBorder() {
        setBorder(BorderFactory.createLineBorder(new Color(0XA67B5B), 1));
    }

    JButton getTileButton() {
        return tileButton;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
