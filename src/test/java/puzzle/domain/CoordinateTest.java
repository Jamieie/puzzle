package puzzle.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CoordinateTest {
    private Coordinate coordinate;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate();
    }

    @DisplayName("특정 좌표의 인접한 좌표 리스트 구하는 기능")
    @CsvSource({"0,0,2", "0,1,3", "0,3,2", "1,0,3", "1,1,4", "3,0,2", "3,2,3", "3,3,2", "2,3,3"})
    @ParameterizedTest
    void findNearCoordinates(int y, int x, int expected) {
        coordinate.setY(y);
        coordinate.setX(x);
        List<Coordinate> nearCoordinates = coordinate.findNearCoordinates();
        assertThat(nearCoordinates.size()).isEqualTo(expected);
    }
}