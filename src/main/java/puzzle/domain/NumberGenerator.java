package puzzle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    private final int NUMBERS_SIZE = 8;

    public List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}
