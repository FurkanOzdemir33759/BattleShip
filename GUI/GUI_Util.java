package GUI;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
public class GUI_Util {

    public static Dimension HD = new Dimension(1280, 720);

    public static void setAbsoluteSize(JComponent component, Dimension size) {
        component.setPreferredSize(size);
        component.setMaximumSize(size);
        component.setMinimumSize(size);
        
    }

    public static void placeAbsoluteComponent(JComponent component, int x, int y, int w, int h) {
        component.setBounds(x, y, w, h);
        setAbsoluteSize(component, new Dimension(w, h));
    }

    public static void alterButtonLook(JButton button) {
        button.setFont(new Font("SansSerif", Font.PLAIN, 24));
        button.setFocusPainted(false);
        button.setBackground(GUI_PALETTE.BACKGROUND);
        button.setForeground(GUI_PALETTE.PLAYER_INFO_TEXT_COLOR);
        button.setBorder(new CompoundBorder(new LineBorder(GUI_PALETTE.GRID_BORDER), new EmptyBorder(2, 5, 2, 5)));
    }
}
