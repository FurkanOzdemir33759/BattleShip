package GUI.NEW;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FleetView extends JPanel {
    private int[] shipsRemaining = {1, 1, 2, 1}; // 5-tile, 4-tile, 3-tile, 2-tile

    public FleetView() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setPreferredSize(new Dimension(400, 100));
        setBackground(Color.LIGHT_GRAY); // Just to visualize the FleetView panel
        add(new JLabel("Click on ships to rotate"));

        // Add ships to FleetView
        addShip(5);
        addShip(4);
        addShip(3);
        addShip(3);
        addShip(2);
    }

    private void addShip(int length) {
        ShipView shipView = new ShipView(length, true);
        shipView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && shipView.isEnabled()) {
                    shipView.toggleOrientation();
                }
            }
        });
        shipView.addDragSourceListener(new DragSourceAdapter() {
            @Override
            public void dragDropEnd(DragSourceDropEvent dsde) {
                // THIS NEVER GETS CALLED. NEEDS FIX
                int shipIndex = 5-shipView.getLength();
                if (dsde.getDropSuccess() && shipsRemaining[shipIndex] > 0) {
                    shipsRemaining[shipIndex]--;
                    if (shipsRemaining[shipIndex] <= 0) {
                        shipView.setEnabled(false);
                        shipView.setBackground(Color.LIGHT_GRAY);
                        shipView.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    }
                }
                revalidate();
                repaint();
            }
        });
        add(shipView);
    }
}
