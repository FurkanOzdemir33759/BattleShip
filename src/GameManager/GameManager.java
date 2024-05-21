package GameManager;

import GameManager.Enums.Orientation;
import GameManager.Enums.Tile;

import java.util.*;

public class GameManager {
    private final int boardSize = 10;
    private int aiHealth = 17;
    private int playerHealth = 17;

    private  int playerMiss = 0;
    private  int aiMiss = 0;

    private  int playerMissX = 1;
    private  int aiMissX = 1;

    private  int playerHitX = 1;
    private  int aiHitX = 1;
    private ArrayList<ArrayList<Tile>> playerGrid = new ArrayList<>();

    private ArrayList<ArrayList<Tile>> aiGrid = new ArrayList<>();


    //private  ArrayList<Ship> playerShips ;
    private  Dictionary<Tile,Ship> playerShips = new Hashtable<>();
    private  Dictionary<Tile,Ship> aiShips = new Hashtable<>();



    public  GameManager(){

        playerShips.put(Tile.SHIP_DESTROYER,new DES() );
        playerShips.put(Tile.SHIP_CRUISER,new CR() );
        playerShips.put(Tile.SHIP_SUBMARINE,new SUB() );
        playerShips.put(Tile.SHIP_AIRCRAFT_CARRIER,new AC() );
        playerShips.put(Tile.SHIP_BATTLESHIP,new BS() );



        aiShips.put(Tile.SHIP_DESTROYER,new DES() );
        aiShips.put(Tile.SHIP_CRUISER,new CR() );
        aiShips.put(Tile.SHIP_SUBMARINE,new SUB() );
        aiShips.put(Tile.SHIP_AIRCRAFT_CARRIER,new AC() );
        aiShips.put(Tile.SHIP_BATTLESHIP,new BS() );


        playerGrid = randomShipPlacement(playerShips);
        aiGrid = randomShipPlacement(aiShips);


    }
    public  ArrayList<ArrayList<Tile>> getPlayerGrid() { return  playerGrid;}
    public  ArrayList<ArrayList<Tile>> getAiGrid() { return  aiGrid;}

    public  Dictionary<Tile,Ship> getPlayerShips(){ return playerShips; }
    public  Dictionary<Tile,Ship> getAiShips(){ return aiShips; }
    private   ArrayList<ArrayList<Tile>> randomShipPlacement( Dictionary<Tile,Ship> ships) {
        Random random = new Random();
        ArrayList<ArrayList<Tile>> result = initEmptyGrid();

        ArrayList<Ship> shipsToPlace = new ArrayList<Ship>(Arrays.asList(
                new AC(), new BS(), new CR(), new SUB(), new DES()
        ));


        while (!shipsToPlace.isEmpty()) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Orientation orientation = (random.nextInt(2) == 0) ? Orientation.HORIZONTAL : Orientation.VERTICAL;
            Ship currentShip = shipsToPlace.get(0);
            int length = currentShip.length;
            if (canPlace(result, length, x, y, orientation)) {
                placeShip(result, currentShip, x, y, orientation);
                currentShip.worldPosX = x;
                currentShip.worldPosY = y;
                currentShip.orientation = orientation;

                ships.put(currentShip.shipTile, currentShip);
                shipsToPlace.remove(0);

            }
        }
        return result;
    }

    private  ArrayList<ArrayList<Tile>> initEmptyGrid() {
        ArrayList<ArrayList<Tile>> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(Tile.EMPTY);
            }
            result.add(row);
        }
        return result;
    }

    public   boolean canPlace(ArrayList<ArrayList<Tile>> grid, int length, int x, int y, Orientation orientation) {
        switch (orientation) {
            case VERTICAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int col_idx = y + offset;
                    if (col_idx < 10 && col_idx >= 0) {
                        if (grid.get(x).get(col_idx) != Tile.EMPTY) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            case HORIZONTAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int row_idx = x + offset;
                    if (row_idx < 10 && row_idx >= 0) {
                        if (grid.get(row_idx).get(y) != Tile.EMPTY) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public   boolean canPlace(ArrayList<ArrayList<Tile>> grid, Ship ship,int x, int y, Orientation ori) {

        int length = ship.length;

        switch (ori) {
            case VERTICAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int col_idx = y + offset;
                    if (col_idx < 10 && col_idx >= 0) {
                        if (grid.get(x).get(col_idx) != Tile.EMPTY && grid.get(x).get(col_idx) != ship.shipTile) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            case HORIZONTAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int row_idx = x + offset;
                    if (row_idx < 10 && row_idx >= 0) {
                        if (grid.get(row_idx).get(y) != Tile.EMPTY && grid.get(row_idx).get(y) != ship.shipTile) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }



    public void placeShip(ArrayList<ArrayList<Tile>> grid, Ship ship, int x, int y, Orientation orientation) {
        int length = ship.length;
        Tile tile = ship.shipTile;
        ship.worldPosX = x;
        ship.worldPosY= y;
        switch (orientation) {
            case VERTICAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int col_idx = y + offset;
                    grid.get(x).set(col_idx, tile);

                }
            }
            case HORIZONTAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int row_idx = x + offset;
                    grid.get(row_idx).set(y, tile);
                }
            }
        }
    }
    public void removeShip(ArrayList<ArrayList<Tile>> grid, Ship ship) {
        int length = ship.length;
        Tile tile = Tile.EMPTY;
        int x = ship.worldPosX;
        int y= ship.worldPosY;
        Orientation orientation = ship.orientation;
        switch (orientation) {
            case VERTICAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int col_idx = y + offset;
                    boolean validate =  grid.get(x).get(col_idx) == ship.shipTile;
                    if(validate){
                        grid.get(x).set(col_idx, tile);
                    }else{
                    }

                }
            }
            case HORIZONTAL -> {
                for (int i = 0; i < length; i++) {
                    int offset = i - length / 2;
                    int row_idx = x + offset;

                    boolean validate =  grid.get(row_idx).get(y) == ship.shipTile;
                    if(validate){
                        grid.get(row_idx).set(y, tile);
                    }else{
                    }

                }
            }
        }
    }

    public void setAiTileData(Tile tile, int x, int y) {
        aiGrid.get(x).set(y, tile);
    }

    public void setPlayerTileData(Tile tile, int x, int y) {
        playerGrid.get(x).set(y, tile);
    }

    public void reduceAiHealth() {
        aiHealth -= 1;
        playerMissX = 1;
        playerMiss -=playerHitX;
        playerHitX ++;

    }

    public void reducePlayerHealth() {
        playerHealth -= 1;
        aiMissX = 1;
        aiMiss -= aiHitX;
        aiHitX ++;
    }

    public int getAiHealth() {
        return aiHealth;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }


    public  void recordPlayerMiss(){
        playerMiss += playerMissX;
        playerHitX = 1;
        if(playerMissX <4){
            playerMissX ++;
        }
    }

    public  void recordAiMiss(){
        aiMiss += aiMissX;
        aiHitX = 1;
        if(aiMissX <4){
            aiMissX ++;
        }
    }

    public int getPlayerScore(){return 400 - playerMiss;}

    public  int getAiScore(){return  400 - aiMiss;}
}
