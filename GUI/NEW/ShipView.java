package GUI.NEW;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class ShipView extends JPanel {
    private final int length;
    private boolean isVertical;
    private boolean isPlaced = false;

    public ShipView(int length, boolean isVertical) {
        this.length = length;
        this.isVertical = isVertical;

        updateLayout();
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        new ShipDragGestureListener(this);
    }

    private void updateLayout() {
        removeAll();
        setLayout(new GridLayout(isVertical ? length : 1, isVertical ? 1 : length));
        for (int i = 0; i < length; i++) {
            JPanel cell = new JPanel();
            cell.setBackground(Color.DARK_GRAY);
            cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(cell);
        }
    }

    public void toggleOrientation() {
        if (!isPlaced) {
            this.isVertical = !this.isVertical;
            updateLayout();
            revalidate();
            repaint();
        }
    }

    public void markAsPlaced() {
        isPlaced = true;
        setEnabled(false);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    public int getLength() {
        return length;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public void addDragSourceListener(DragSourceListener dsl) {
        DragSource.getDefaultDragSource().addDragSourceListener(dsl);
    }
}

class ShipDragGestureListener extends DragSourceAdapter implements DragGestureListener {
    DragSource dragSource;

    public ShipDragGestureListener(JComponent component) {
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(component, DnDConstants.ACTION_MOVE, this);
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JComponent component = (JComponent) event.getComponent();
        if (component.isEnabled()) {
            Transferable transferable = new ShipTransferable(component);
            event.startDrag(DragSource.DefaultMoveDrop, transferable, this);
        }
    }
}

class ShipTransferable implements Transferable {
    private final JComponent component;

    public ShipTransferable(JComponent component) {
        this.component = component;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{new DataFlavor(JComponent.class, "JComponent")};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.getRepresentationClass() == JComponent.class;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) {
        return component;
    }
}
