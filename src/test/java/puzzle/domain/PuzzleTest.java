package puzzle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PuzzleTest {
    private Puzzle puzzle;

    private final Map<Integer, List<Integer>> numbers = Map.of(
            0, new ArrayList<>(Arrays.asList(1,2,3,4)),
            1, new ArrayList<>(Arrays.asList(5,6,7,8)),
            2, new ArrayList<>(Arrays.asList(9,10,16,12)),
            3, new ArrayList<>(Arrays.asList(13,14,15,11))
    );

    @DisplayName("특정 값을 빈자리로 옮기는 기능")
    @CsvSource({"7,1", "10,2", "12,2", "15,3"})
    @ParameterizedTest
    void move(int input, int row) {
        puzzle = new Puzzle(numbers);
        puzzle.move(input);
        assertThat(numbers.get(2)).contains(input);
        assertThat(numbers.get(row)).contains(16);
    }

    @DisplayName("특정값 주변에 빈자리가 있는지 확인하는 기능")
    @CsvSource({"7,true", "10,true", "12,true", "15,true", "6,false", "8,false", "14,false", "11,false", "3,false"})
    @ParameterizedTest
    void hasVacancyNear(int value, boolean expected) {
        puzzle = new Puzzle(numbers);
        boolean result = puzzle.hasVacancyNear(value);
        assertThat(result).isEqualTo(expected);
    }
}