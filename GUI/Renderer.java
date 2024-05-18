package GUI;

import GUI.Enums.Phase;
import javax.swing.*;
import java.awt.*;


/**
 * This class is responsible for rendering the game.
 */
public class Renderer extends JFrame {

    private JPanel container;

    /**
     * Tells renderer what to render currently.
     */
    private Phase phase = Phase.MAIN_MENU;


    private JLayeredPane layeredPane;
    private JPanel panelPass;

    private JPanel uiPass;
    Renderer(JPanel initialPanel) {

        setTitle("BattleShip");
        setSize(1280, 720);
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("Resources/AppIcon.jpeg");
        setIconImage(icon);

        uiPass = new JPanel();
        uiPass.setOpaque(false);
        panelPass = initialPanel;

        panelPass.setBounds(0, 0, 1280, 720);
        uiPass.setBounds(0, 0, 1280, 720);


        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1280, 720));
        layeredPane.setLayout(null);  // Use absolute positioning

        add(layeredPane);

        layeredPane.add(panelPass,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(uiPass,JLayeredPane.PALETTE_LAYER);

        //setContentPane(currentPanel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    public  void Render( JPanel panelPass_ ){
        layeredPane.remove(panelPass);
        panelPass = panelPass_;


        panelPass.setBounds(0, 0, 1280, 720);

        Dimension panelSize = panelPass.getPreferredSize();
        panelPass.setBounds((1280 - panelSize.width) / 2, (720 - panelSize.height) / 2, panelSize.width, panelSize.height);

        layeredPane.add(panelPass,JLayeredPane.DEFAULT_LAYER);

        layeredPane.revalidate();
        layeredPane.repaint();

    }

    public void RenderUI(JPanel uiPass_){
        layeredPane.remove(uiPass);
        panelPass = uiPass_;


        panelPass.setBounds(0, 0, 1280, 720);

        Dimension panelSize = panelPass.getPreferredSize();
        panelPass.setBounds((1280 - panelSize.width) / 2, (720 - panelSize.height) / 2, panelSize.width, panelSize.height);

        layeredPane.add(uiPass,JLayeredPane.DEFAULT_LAYER);

        layeredPane.revalidate();
        layeredPane.repaint();

    }


}
