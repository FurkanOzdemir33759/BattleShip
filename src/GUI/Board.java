package GUI;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


import GameManager.Enums.*;

public class Board extends JPanel {
    private Point initialClick;
    private final int GRID_SIZE = 56;
    public class TileView extends JPanel {
        private Player tileOwner = Player.PLAYER;
        private Tile tile;
        private int x;
        private int y;
        private static ImageIcon icon = resizeImageIcon(new ImageIcon("resources/destroyed_tile.png"), 40, 40);

        public TileView(Tile tile, int x, int y) {
            this.tile = tile;
            this.x = x;
            this.y = y;
            GUI_Util.setAbsoluteSize(this, new Dimension(56, 56));
            adjustBackground();
            setBorder(BorderFactory.createLineBorder(GUI_PALETTE.GRID_BORDER, 2, false));
        }

        private TileView(Tile tile, int x, int y, Player tileOwner) {
            this(tile, x, y);
            this.tileOwner = tileOwner;
            adjustBackground();
        }

        private void adjustBackground() {
            Color backgroundColor = GUI_PALETTE.EMPTY;
            if (tileOwner == Player.PLAYER) {
                switch (tile) {
                    case EMPTY -> backgroundColor = GUI_PALETTE.EMPTY;
                    case SHIP_BATTLESHIP -> backgroundColor = GUI_PALETTE.SHIP_BATTLESHIP;
                    case SHIP_DESTROYER -> backgroundColor = GUI_PALETTE.SHIP_DESTROYER;
                    case SHIP_CRUISER -> backgroundColor = GUI_PALETTE.SHIP_CRUISER;
                    case SHIP_AIRCRAFT_CARRIER -> backgroundColor = GUI_PALETTE.SHIP_AIRCRAFT_CARRIER;
                    case SHIP_SUBMARINE -> backgroundColor = GUI_PALETTE.SHIP_SUBMARINE;
                    case REVEALED_EMPTY -> backgroundColor = GUI_PALETTE.REVEALED_EMPTY;
                    case REVEALED_SHIP ->  {
                        JLabel iconLabel = new JLabel(icon);
                        GUI_Util.placeAbsoluteComponent(iconLabel, 0, 0, 50, 45);
                        add(iconLabel);
                        setBackground(backgroundColor);
                    }
                }
            } else {
                switch (tile) {
                    case REVEALED_EMPTY -> backgroundColor = GUI_PALETTE.REVEALED_EMPTY;
                    case REVEALED_SHIP ->  {
                        JLabel iconLabel = new JLabel(icon);
                        GUI_Util.placeAbsoluteComponent(iconLabel, 0, 0, 50, 45);
                        add(iconLabel);
                    }
                    default -> backgroundColor = GUI_PALETTE.EMPTY;
                }
            }
            setBackground(backgroundColor);
        }
    }
    private ArrayList<ArrayList<Tile>> grid;
    private ArrayList<ArrayList<TileView>> gridView;

    private Player boardOwner;



    public Board(Player boardOwner, ArrayList<ArrayList<Tile>> grid) {
        this.grid = grid;
        this.boardOwner = boardOwner;
        GUI_Util.setAbsoluteSize(this, new Dimension(560, 560));
        setLayout(null);

        if (grid.size() > 0) {
            renderGrid();
        }
    }



    public void renderGrid() {
        gridView = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<TileView> rowView = new ArrayList<>();
            for (int j  = 0; j < 10; j++) {
                TileView tileView = new TileView(grid.get(i).get(j), i, j, boardOwner);
                rowView.add(tileView);
                GUI_Util.placeAbsoluteComponent(tileView, GRID_SIZE  * i, GRID_SIZE * j, GRID_SIZE, GRID_SIZE);
                add(tileView);
            }
            gridView.add(rowView);
            revalidate();
            repaint();
        }
    }
    public void updateGrid(ArrayList<ArrayList<Tile>> grid) {
        clearGrid();
        gridView = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            ArrayList<TileView> rowView = new ArrayList<>();
            for (int i  = 0; i < 10; i++) {
                TileView tileView = new TileView(grid.get(i).get(j), i, j, boardOwner);
                rowView.add(tileView);
                GUI_Util.placeAbsoluteComponent(tileView, GRID_SIZE  * i, GRID_SIZE * j, GRID_SIZE, GRID_SIZE);
                add(tileView);
            }
            gridView.add(rowView);

        }
        revalidate();
        repaint();
    }
    private void clearGrid(){
        for( ArrayList<TileView> row : gridView){
            for(TileView t : row){
                remove(t);

            }
        }

    }
    public void setGrid(ArrayList<ArrayList<Tile>> grid) {
        this.grid = grid;
    }

    public ArrayList<ArrayList<Tile>> getGrid() {
        return grid;
    }

    public Point getInitialClick() {
        return initialClick;
    }

    public int getGRID_SIZE() {
        return GRID_SIZE;
    }

    public void setInitialClick(Point p) {
        initialClick = p;
    }

    public TileView getTileViewAt(Point p) {
        int x = p.x / GRID_SIZE;
        int y = p.y / GRID_SIZE;
        return gridView.get(x).get(y);
    }

    public Point viewToWorldPoint(Point p) {
        int x = p.x / GRID_SIZE;
        int y = p.y / GRID_SIZE;
        return new Point(x,y);
    }

    private static ImageIcon resizeImageIcon(ImageIcon originalIcon, int width, int height) {
        Image image = originalIcon.getImage(); // Extract the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Return the resized ImageIcon
    }


}
