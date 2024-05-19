package GUI.NEW;

import GUI.Enums.PALETTE;
import GameManager.Enums.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class TileView extends JPanel implements DropTargetListener {
    private final int x;
    private final int y;
    private Player tileOwner;
    private boolean isRevealed = false;
    private boolean isEmpty = true; // make sure it's initially empty
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
        new DropTarget(this, DnDConstants.ACTION_MOVE, this, true);
    }

    private void adjustColor() {
        if (!isRevealed) {
            setBackground(PALETTE.WATER);
        } else {
            if (isEmpty) {
                setBackground(new Color(0X32012F));
            } else {
                setBackground(new Color(0XFF5F00));
            }
        }
    }

    private void adjustBorder() {
        setBorder(BorderFactory.createLineBorder(new Color(0XA67B5B), 1));
    }

    JButton getTileButton() {
        return tileButton;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setOccupied() {
        isEmpty = false;
        setBackground(new Color(0XFF5F00));
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {}

    @Override
    public void dragOver(DropTargetDragEvent dtde) {}

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {}

    @Override
    public void dragExit(DropTargetEvent dte) {}

    @Override
    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable transferable = dtde.getTransferable();
            if (transferable.isDataFlavorSupported(new DataFlavor(JComponent.class, "JComponent"))) {
                dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                JComponent component = (JComponent) transferable.getTransferData(new DataFlavor(JComponent.class, "JComponent"));
                if (component instanceof ShipView) {
                    ShipView ship = (ShipView) component;
                    BoardView board = (BoardView) this.getParent();
                    if (board.canPlaceShip(x, y, ship)) {
                        board.placeShip(x, y, ship); // Mark the tiles as occupied
                        ship.markAsPlaced();
                    }
                }
                dtde.dropComplete(true);
            } else {
                dtde.rejectDrop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        }
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
