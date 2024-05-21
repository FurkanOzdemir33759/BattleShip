package GameController;

import GameManager.Enums.MemoryTile;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the CPU.
 */
public class AI {
    private Random random = new Random();
    private ArrayList<ArrayList<MemoryTile>> gridMemory = initGridMemory();



    public AI() {
    }

    public Point nextTarget() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gridMemory.get(i).get(j) == MemoryTile.HIGH_PRIORITY) {
                    return new Point(i ,j);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gridMemory.get(i).get(j) == MemoryTile.MEDIUM_PRIORITY) {
                    return new Point(i ,j);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gridMemory.get(i).get(j) == MemoryTile.LOW_PRIORITY) {
                    return new Point(i ,j);
                }
            }
        }
        Point point = new Point(random.nextInt(10), random.nextInt(10));
        while (gridMemory.get(point.x).get(point.y) != MemoryTile.UNKNOWN) {
            point = new Point(random.nextInt(10), random.nextInt(10));
        }
        return point;
    }

    public void setGridMemory(int x, int y, MemoryTile result) {
        switch (result) {
            case HIT -> {
                int x_offset = 1, y_offset = 0;
                if (validateRange(x - x_offset, y - y_offset) && gridMemory.get(x - x_offset).get(y - y_offset) == MemoryTile.HIT && validateRange(x + x_offset, y + y_offset) && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.MISS && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.HIT) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.HIGH_PRIORITY);
                } else
                if (validateRange(x + x_offset, y + y_offset) && (gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN || gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.LOW_PRIORITY)) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.MEDIUM_PRIORITY);
                }
                x_offset = -1; y_offset = 0;
                if (validateRange(x - x_offset, y - y_offset) && gridMemory.get(x - x_offset).get(y - y_offset) == MemoryTile.HIT && validateRange(x + x_offset, y + y_offset) && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.MISS && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.HIT) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.HIGH_PRIORITY);
                } else
                if (validateRange(x + x_offset, y + y_offset) && (gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN || gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.LOW_PRIORITY)) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.MEDIUM_PRIORITY);
                }
                x_offset = 0; y_offset = 1;
                if (validateRange(x - x_offset, y - y_offset) && gridMemory.get(x - x_offset).get(y - y_offset) == MemoryTile.HIT && validateRange(x + x_offset, y + y_offset)  && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.MISS && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.HIT) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.HIGH_PRIORITY);
                } else
                if (validateRange(x + x_offset, y + y_offset) && (gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN || gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.LOW_PRIORITY)) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.MEDIUM_PRIORITY);
                }
                x_offset = 0; y_offset = -1;
                if (validateRange(x - x_offset, y - y_offset) && gridMemory.get(x - x_offset).get(y - y_offset) == MemoryTile.HIT && validateRange(x + x_offset, y + y_offset)  && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.MISS && gridMemory.get(x + x_offset).get(y + y_offset) != MemoryTile.HIT) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.HIGH_PRIORITY);
                } else
                if (validateRange(x + x_offset, y + y_offset) && (gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN || gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.LOW_PRIORITY)) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.MEDIUM_PRIORITY);
                }
            }
            case MISS -> {/*
                int x_offset = 1, y_offset = 1;
                if (validateRange(x + x_offset, y + y_offset) && gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.LOW_PRIORITY);
                }
                x_offset = -1; y_offset = -1;
                if (validateRange(x + x_offset, y + y_offset) && gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.LOW_PRIORITY);
                }
                x_offset = -1; y_offset = +1;
                if (validateRange(x + x_offset, y + y_offset) && gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.LOW_PRIORITY);
                }
                x_offset = +1; y_offset = -1;
                if (validateRange(x + x_offset, y + y_offset) && gridMemory.get(x + x_offset).get(y + y_offset) == MemoryTile.UNKNOWN) {
                    gridMemory.get(x + x_offset).set(y + y_offset, MemoryTile.LOW_PRIORITY);
                }*/
            }
        }
        gridMemory.get(x).set(y, result);
    }



    private static boolean validateRange(int x, int y) {
        return (0 <= x && x < 10 && 0 <= y && y < 10);
    }

    private static ArrayList<ArrayList<MemoryTile>> initGridMemory() {
        ArrayList<ArrayList<MemoryTile>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<MemoryTile> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(MemoryTile.UNKNOWN);
            }
            result.add(row);
        }
        return result;
    }
}