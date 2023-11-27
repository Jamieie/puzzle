package puzzle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PuzzleTest {
    private Puzzle puzzle;

    private final Map<Integer, List<Integer>> NUMBERS_SORTED = Map.of(
            0, new ArrayList<>(Arrays.asList(1,2,3,4)),
            1, new ArrayList<>(Arrays.asList(5,6,7,8)),
            2, new ArrayList<>(Arrays.asList(9,10,11,12)),
            3, new ArrayList<>(Arrays.asList(13,14,15,16))
    );

    private final Map<Integer, List<Integer>> NUMBERS_UNSORTED_1 = Map.of(
            0, new ArrayList<>(Arrays.asList(1,2,3,4)),
            1, new ArrayList<>(Arrays.asList(5,6,7,8)),
            2, new ArrayList<>(Arrays.asList(9,10,16,12)),
            3, new ArrayList<>(Arrays.asList(13,14,15,11))
    );

    private final Map<Integer, List<Integer>> NUMBERS_UNSORTED_2 = Map.of(
            0, new ArrayList<>(Arrays.asList(1,2,3,4)),
            1, new ArrayList<>(Arrays.asList(5,6,7,8)),
            2, new ArrayList<>(Arrays.asList(13,14,15,16)),
            3, new ArrayList<>(Arrays.asList(9,10,11,12))
    );

    @DisplayName("특정 값을 빈자리로 옮기는 기능")
    @CsvSource({"7,1", "10,2", "12,2", "15,3"})
    @ParameterizedTest
    void move(int input, int row) {
        puzzle = new Puzzle(NUMBERS_UNSORTED_1);
        puzzle.move(input);
        assertThat(NUMBERS_UNSORTED_1.get(2)).contains(input);
        assertThat(NUMBERS_UNSORTED_1.get(row)).contains(16);
    }

    @DisplayName("특정값 주변에 빈자리가 있는지 확인하는 기능")
    @CsvSource({"7,true", "10,true", "12,true", "15,true", "6,false", "8,false", "14,false", "11,false", "3,false"})
    @ParameterizedTest
    void hasVacancyNear(int value, boolean expected) {
        puzzle = new Puzzle(NUMBERS_UNSORTED_1);
        boolean result = puzzle.isNearVacancy(value);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("퍼즐이 오름차순으로 정렬되어 있으면 true를 반환한다.")
    @Test
    void isSorted_sorted() {
        puzzle = new Puzzle(NUMBERS_SORTED);
        boolean result = puzzle.isSorted();
        assertThat(result).isTrue();
    }

    @DisplayName("퍼즐이 오름차순으로 정렬되어 있지 않으면 false를 반환한다.")
    @Test
    void isSorted_unsorted1() {
        puzzle = new Puzzle(NUMBERS_UNSORTED_1);
        boolean result = puzzle.isSorted();
        assertThat(result).isFalse();
    }

    @DisplayName("퍼즐이 오름차순으로 정렬되어 있지 않으면 false를 반환한다.")
    @Test
    void isSorted_unsorted2() {
        puzzle = new Puzzle(NUMBERS_UNSORTED_2);
        boolean result = puzzle.isSorted();
        assertThat(result).isFalse();
    }
}