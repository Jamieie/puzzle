package puzzle.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class NumberGeneratorTest {

    NumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new NumberGenerator();
    }

    @DisplayName("네 개의 숫자 리스트를 가진 map 생성")
    @Test
    void createRows() {
        Map<Integer, List<Integer>> lists = generator.createNumbers();
        Assertions.assertThat(lists.size()).isEqualTo(4);
    }
}