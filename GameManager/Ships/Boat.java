package GameManager.Ships;

import GameManager.Enums.Orientation;

import java.util.ArrayList;
import java.util.Arrays;

public class Boat extends ShipObject {
    public Boat(int x, int y, Orientation orientation) {
        super(x, y, orientation, new ArrayList<Integer>(Arrays.asList(1)));
    }
}
