package puzzle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PuzzleTest {
    private Puzzle puzzle;

    @DisplayName("리스트에서 특정 두 값의 위치를 서로 바꾸는 기능")
    @Test
    void swap() {
        puzzle = new Puzzle(Arrays.asList(1,2,3,4,5,6,7,8));
        List<Integer> tradeValues = Arrays.asList(1, 7);
        puzzle.swap(tradeValues);
        assertThat(puzzle.getNumbers()).isEqualTo(Arrays.asList(7,2,3,4,5,6,1,8));
    }

    @DisplayName("리스트가 오름차순으로 정렬되어 있으면 true 반환")
    @Test
    void isSorted_sorted_true() {
        puzzle = new Puzzle(Arrays.asList(1,2,3,4,5,6,7,8));
        assertThat(puzzle.isSorted()).isTrue();
    }

    @DisplayName("리스트가 오름차순으로 정렬되어 있지 않으면 false 반환")
    @Test
    void isSorted_unsorted_false() {
        puzzle = new Puzzle(Arrays.asList(1,2,3,5,6,4,7,8));
        assertThat(puzzle.isSorted()).isFalse();
    }
}