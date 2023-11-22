package puzzle.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PuzzleTest {
    private final List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    private Puzzle puzzle;

    @BeforeEach
    void setUp() {
        puzzle = new Puzzle(numbers);
    }

    @DisplayName("리스트에서 특정 두 값의 위치를 서로 바꾸는 기능")
    @Test
    void swap() {
        List<Integer> tradeValues = Arrays.asList(1, 7);
        puzzle.swap(tradeValues);
        assertThat(puzzle.getNumbers()).isEqualTo(Arrays.asList(7,2,3,4,5,6,1,8));
    }
}