package puzzle.domain;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public List<Coordinate> findNearCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        if (y > 0) {
            Coordinate coordinate1 = new Coordinate();
            coordinate1.setY(y-1);
            coordinate1.setX(x);
            coordinates.add(coordinate1);
        }
        if (y < 3) {
            Coordinate coordinate1 = new Coordinate();
            coordinate1.setY(y+1);
            coordinate1.setX(x);
            coordinates.add(coordinate1);
        }
        if (x > 0) {
            Coordinate coordinate1 = new Coordinate();
            coordinate1.setY(y);
            coordinate1.setX(x-1);
            coordinates.add(coordinate1);
        }
        if (x < 3) {
            Coordinate coordinate1 = new Coordinate();
            coordinate1.setY(y);
            coordinate1.setX(x+1);
            coordinates.add(coordinate1);
        }
        return coordinates;
    }
}
