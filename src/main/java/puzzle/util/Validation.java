package puzzle.util;

import java.util.List;

public class Validation {
    private int RANGE_START = 1;
    private int RANGE_END = 8;

    public boolean isInRange(List<Integer> values) {
        for (int value : values) {
            if (value < RANGE_START || value > RANGE_END) {
                return false;
            }
        }
        return true;
    }

    public boolean hasDuplicate(List<Integer> values) {
        return values.size() != values.stream().distinct().count();
    }
}
