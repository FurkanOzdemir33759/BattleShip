package GameManager;

import GameManager.Enums.Orientation;
import GameManager.Enums.Tile;

public class Ship {
    public Tile shipTile;
    //    public Orientation orientation;
    public int length;

    public int worldPosX;
    public int worldPosY;

    public  Orientation orientation;
    public Ship(Tile shipTile, int length) {
        this.length = length;
        this.shipTile = shipTile;
    }
}

class AC extends Ship {
    public AC() {
        super(Tile.SHIP_AIRCRAFT_CARRIER, 5);
    }
}

class BS extends Ship {
    public BS() {
        super(Tile.SHIP_BATTLESHIP, 4);
    }
}

class CR extends Ship {
    public CR() {
        super(Tile.SHIP_CRUISER, 3);
    }
}

class SUB extends Ship {
    public SUB() {
        super(Tile.SHIP_SUBMARINE, 3);
    }
}

class DES extends Ship {
    public DES() {
        super(Tile.SHIP_DESTROYER, 2);
    }
}

