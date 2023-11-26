package puzzle.domain;

import java.util.List;
import java.util.Map;

public class Puzzle {
    private final int VACANCY_NUMBER = 16;
    private Map<Integer, List<Integer>> numbers;

    public Puzzle(Map<Integer, List<Integer>> numbers) {
        this.numbers = numbers;
    }

    private Coordinate findPosition(int value) {
        Coordinate coordinate = new Coordinate();
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> row = numbers.get(i);
            int index = row.indexOf(value);
            if (index != -1) {
                coordinate.setY(i);
                coordinate.setX(index);
            }
        }
        return coordinate;
    }

    private Coordinate findVacancy() {
        return findPosition(VACANCY_NUMBER);
    }
}
