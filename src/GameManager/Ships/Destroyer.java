package GameManager.Ships;

import GameManager.Enums.Orientation;

import java.util.ArrayList;
import java.util.Arrays;

public class Destroyer extends ShipObject {
    public Destroyer(int x, int y, Orientation orientation) {
        super(x, y, orientation, new ArrayList<Integer>(Arrays.asList(1, 1)));
        setName("Destroyer");
    }
}
