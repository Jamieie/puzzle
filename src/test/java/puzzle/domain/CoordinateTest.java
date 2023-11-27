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
        coordinate.setXY(x, y);
        List<Coordinate> nearCoordinates = coordinate.findNearCoordinates();
        assertThat(nearCoordinates.size()).isEqualTo(expected);
    }

    @DisplayName(("해당 좌표가 특정 좌표와 인접해 있는지 확인하는 기능"))
    @CsvSource({"0,1,true", "2,1,true", "1,0,true", "1,2,true", "0,0,false", "0,2,false", "2,0,false", "2,2,false"})
    @ParameterizedTest
    void isNear(int x, int y, boolean expected) {
        coordinate.setXY(1,1);
        Coordinate coordinate1 = new Coordinate();
        coordinate1.setXY(x, y);
        boolean result = coordinate.isNear(coordinate1);
        assertThat(result).isEqualTo(expected);
    }
}