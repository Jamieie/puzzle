package puzzle.domain;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Coordinate> findNearCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        if (y > 0) {
            Coordinate coordinate = new Coordinate();
            coordinate.setXY(x, y-1);
            coordinates.add(coordinate);
        }
        if (y < 3) {
            Coordinate coordinate = new Coordinate();
            coordinate.setXY(x, y+1);
            coordinates.add(coordinate);
        }
        if (x > 0) {
            Coordinate coordinate = new Coordinate();
            coordinate.setXY(x-1, y);
            coordinates.add(coordinate);
        }
        if (x < 3) {
            Coordinate coordinate = new Coordinate();
            coordinate.setXY(x+1, y);
            coordinates.add(coordinate);
        }
        return coordinates;
    }
}
