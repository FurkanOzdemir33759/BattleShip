package GUI;

import GUI.Interfaces.IMainMenu;

import javax.swing.*;

public class MainMenu extends JPanel implements IMainMenu {
    @Override
    public void startGame() {
        // Implementation code here

    }

    @Override
    public void accessSettings() {
        // Implementation code here

    }

    @Override
    public void exitGame() {
        // Implementation code here

    }

    MainMenu() {
        add(new JLabel("MAIN MENU!"));
    }
}
