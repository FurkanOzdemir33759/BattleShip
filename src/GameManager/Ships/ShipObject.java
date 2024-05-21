package GameManager.Ships;

import GameManager.Enums.Orientation;

import java.util.ArrayList;
import java.util.Arrays;


public class ShipObject {
    /**
     * Helper class for Ships. Not intended to be used elsewhere.
     */
    private class Coordinate {
        /**
         * x position.
         */
        int x;

        /**
         * y position.
         */
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    /**
     * Coordinates of the head of the ship.
     */
    private Coordinate coordinate;
    private String name;
    /**
     * Orientation of the ship.
     */
    private Orientation orientation;

    /**
     * ShipLayout, in combination with the orientation specifies the layout of the ship.
     * It is a list of integers. First square is implicitly (x,y).
     * Other squares in the layout is encoded as directions to take.
     * 0 => relative LEFT of orientation
     * 1 => relative UP of orientation
     * 2 => relative RIGHT of orientation
     * 3 => relative DOWN of orientation
     */
    private ArrayList<Integer> shipLayout;

    ShipObject(int x, int y, Orientation orientation, ArrayList<Integer> shipLayout) {
        this.coordinate = new Coordinate(x,y);
        this.orientation = orientation;
        this.shipLayout = shipLayout;
    }

    private Coordinate relativeToAbsoluteCoordinate(Coordinate currentPosition, Orientation orientation, int direction) throws ArrayIndexOutOfBoundsException {
        Coordinate abs_left = new Coordinate(-1, 0);
        Coordinate abs_right = new Coordinate(1, 0);
        Coordinate abs_up = new Coordinate(0, 1);
        Coordinate abs_down = new Coordinate(0, -1);
        Coordinate offset = new Coordinate(0, 0);
        switch (direction) {
            case 0 -> {
                switch (orientation) {
                    case LEFT -> offset = abs_down;
                    case UP -> offset = abs_left;
                    case RIGHT -> offset = abs_up;
                    case DOWN -> offset = abs_right;
                }
            }
            case 1 -> {
                switch (orientation) {
                    case LEFT -> offset = abs_left;
                    case UP -> offset = abs_up;
                    case RIGHT -> offset = abs_right;
                    case DOWN -> offset = abs_down;
                }
            }
            case 2 -> {
                switch (orientation) {
                    case LEFT -> offset = abs_up;
                    case UP -> offset = abs_right;
                    case RIGHT -> offset = abs_down;
                    case DOWN -> offset = abs_left;
                }
            }
            case 3 -> {
                switch (orientation) {
                    case LEFT -> offset = abs_right;
                    case UP -> offset = abs_down;
                    case RIGHT -> offset = abs_left;
                    case DOWN -> offset = abs_up;
                }
            }
        }
        return new Coordinate(currentPosition.x + offset.x, currentPosition.y + offset.y);
    }

    private ArrayList<Coordinate> getPlacementCoordinates() {
        ArrayList<Coordinate> result = new ArrayList<>();
        result.add(coordinate);
        Coordinate lastCoordinate = coordinate;

        for (int direction:shipLayout) {
            Coordinate nextCoordinate = relativeToAbsoluteCoordinate(lastCoordinate, orientation, direction);
            result.add(nextCoordinate);
            lastCoordinate = nextCoordinate;
        }

        return result;
    }

    private ArrayList<Integer> coordToIntArray(Coordinate coord) {
        return new ArrayList<Integer>(Arrays.asList(coord.x, coord.y));
    }

    public ArrayList<ArrayList<Integer>> getShipLayoutForButton() {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Coordinate lastCoordinate = new Coordinate(0,0);

        for (int direction:shipLayout) {
            Coordinate next = relativeToAbsoluteCoordinate(lastCoordinate, Orientation.RIGHT, direction);
            res.add(coordToIntArray(next));
            lastCoordinate = next;
        }

        return res;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}