package puzzle.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("입력값이 1 이상 15 이하의 값인지 확인하는 기능")
    @CsvSource({"0,false", "1,true", "15,true", "16,false"})
    @ParameterizedTest
    void isInRange(int input, boolean expected) {
        boolean result = validation.isInRange(input);
        assertThat(result).isEqualTo(expected);
    }
}