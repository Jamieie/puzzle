package puzzle.domain;

import java.util.*;

public class NumberGenerator {
    private final int PUZZLE_SIZE = 16;
    private final int PUZZLE_SIDE_LENGTH = 4;

    public Map<Integer, List<Integer>> createNumbers() {
        List<Integer> shuffled = shuffleNumbers();
        Map<Integer, List<Integer>> numbers = new HashMap<>();
        for (int i = 0; i < PUZZLE_SIDE_LENGTH; i++) {
            List<Integer> rowNumbers = new ArrayList<>();
            for (int j = 0; j < PUZZLE_SIDE_LENGTH; j++) {
                rowNumbers.add(shuffled.get(0));
                shuffled.remove(0);
            }
            numbers.put(i, rowNumbers);
        }
        return numbers;
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}
