package GUI;

import GUI.Interfaces.INotification;

import javax.swing.*;

public class Notification extends JPanel implements INotification {
    @Override
    public void displayHitMiss() {
        // Implementation code here

    }

    @Override
    public void displayGameResults() {
        // Implementation code here

    }

    Notification() {
        add(new JLabel("NOTIFICATION"));
    }
}
