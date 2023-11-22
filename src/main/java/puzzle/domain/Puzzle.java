package puzzle.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Puzzle {
    private List<Integer> numbers;

    public Puzzle(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void swap(List<Integer> values) {
        int index1 = numbers.indexOf(values.get(0));
        int index2 = numbers.indexOf(values.get(1));

        Collections.swap(numbers, index1, index2);
    }

    public boolean isSorted() {
        return IntStream.range(0, numbers.size()-1).allMatch(i -> numbers.get(i) < numbers.get(i + 1));
    }
}
