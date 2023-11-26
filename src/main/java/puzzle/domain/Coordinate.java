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
            coordinates = addCoordinates(coordinates, x, y - 1);
        }
        if (y < 3) {
            coordinates = addCoordinates(coordinates, x, y + 1);
        }
        if (x > 0) {
            coordinates = addCoordinates(coordinates, x - 1, y);
        }
        if (x < 3) {
            coordinates = addCoordinates(coordinates, x + 1, y);
        }
        return coordinates;
    }

    private List<Coordinate> addCoordinates(List<Coordinate> coordinates, int x, int y) {
        Coordinate coordinate = new Coordinate();
        coordinate.setXY(x, y);
        coordinates.add(coordinate);
        return coordinates;
    }

    public boolean isSameAs(Coordinate coordinate) {
        return coordinate.getX() == x && coordinate.getY() == y;
    }
}
