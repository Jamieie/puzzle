package puzzle.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Puzzle {
    private final int VACANCY_NUMBER = 16;
    private final int FIRST_INDEX = 0;
    private final int LAST_INDEX = 3;

    private Map<Integer, List<Integer>> numbers;

    public Puzzle(Map<Integer, List<Integer>> numbers) {
        this.numbers = numbers;
    }

    public Map<Integer, List<Integer>> getNumbers() {
        return numbers;
    }

    public void move(int value) {
        Coordinate valuePosition = findPosition(value);
        Coordinate vacancyPosition = findVacancy();

        List<Integer> valueRow = numbers.get(valuePosition.getY());
        List<Integer> vacancyRow = numbers.get(vacancyPosition.getY());

        valueRow.remove(Integer.valueOf(value));
        vacancyRow.add(vacancyPosition.getX(), value);
        vacancyRow.remove(Integer.valueOf(VACANCY_NUMBER));
        valueRow.add(valuePosition.getX(), VACANCY_NUMBER);
    }

    private Coordinate findPosition(int value) {
        Coordinate coordinate = new Coordinate();
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> row = numbers.get(i);
            int index = row.indexOf(value);
            if (index != -1) {
                coordinate.setXY(index, i);
            }
        }
        return coordinate;
    }

    private Coordinate findVacancy() {
        return findPosition(VACANCY_NUMBER);
    }

    public boolean isNearVacancy(int value) {
        Coordinate position = findPosition(value);
        Coordinate vacancy = findVacancy();
        return position.isNear(vacancy);
    }

    public boolean isSorted() {
        // 각 열이 오름차순으로 정렬되어 있는지 확인
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> row = numbers.get(i);
            if (!isSortedRow(row)) {
                return false;
            }
        }
        // 각 열의 마지막 숫자 보다 뒷열의 첫번째 숫자가 큰지 확인
        for (int i = 0; i < numbers.size() - 1; i++) {
            List<Integer> row = numbers.get(i);
            List<Integer> rowAfter = numbers.get(i + 1);
            if (!(row.get(LAST_INDEX) < rowAfter.get(FIRST_INDEX))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedRow(List<Integer> row) {
        if (row == null || row.size() <= 1) {
            return true;
        }
        return IntStream.range(0, row.size()-1).allMatch(i -> row.get(i) < row.get(i+1));
    }
}
