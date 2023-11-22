package puzzle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("1~8범위의 서로 다른 숫자가 담긴 길이 8의 리스트 생성")
    @Test
    void createNumbers() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.createNumbers();
        assertThat(numbers).contains(1,2,3,4,5,6,7,8);
    }
}