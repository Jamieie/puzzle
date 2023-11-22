package puzzle.domain;

import java.util.Collections;
import java.util.List;

public class Puzzle {
    private List<Integer> numbers;

    public Puzzle(List<Integer> puzzles) {
        this.numbers = puzzles;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void swap(List<Integer> values) {
        int index1 = numbers.indexOf(Integer.valueOf(values.get(0)));
        int index2 = numbers.indexOf(Integer.valueOf(values.get(1)));

        Collections.swap(numbers, index1, index2);
    }
}
