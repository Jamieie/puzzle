package puzzle.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {

    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("리스트 안에 있는 숫자가 모두 1~8 범위 안의 숫자가 맞는지 확인하는 기능")
    @CsvSource({"0,1,false", "1,2,true", "7,8,true", "8,9,false"})
    @ParameterizedTest
    void isInRange(int value1, int value2, boolean expected) {
        List<Integer> values = Arrays.asList(value1, value2);
        assertThat(validation.isInRange(values)).isEqualTo(expected);
    }

}