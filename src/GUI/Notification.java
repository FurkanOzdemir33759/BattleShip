package GUI;

import GUI.Interfaces.INotification;

import javax.swing.*;
import java.awt.*;

public class Notification extends JPanel implements INotification {
    private JLabel notificationLabel;
    public Notification() {
        setLayout(new BorderLayout());
        notificationLabel = new JLabel("NOTIFICATION", SwingConstants.CENTER);
        add(notificationLabel, BorderLayout.CENTER);
    }

    @Override
    public void displayHitMiss(boolean isHit) {
        if (isHit) {
            notificationLabel.setText("Hit!");
            notificationLabel.setForeground(Color.RED);
        } else {
            notificationLabel.setText("Miss!");
            notificationLabel.setForeground(Color.BLUE);
        }
    }

    @Override
    public void displayGameResults(String result) {
        notificationLabel.setText(result);
        notificationLabel.setForeground(Color.GREEN);
    }

}
