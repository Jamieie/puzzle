package puzzle.util;

public class Validation {
    private final int RANGE_START = 1;
    private final int RANGE_END = 15;

    public boolean isInRange(int input) {
        return input >= RANGE_START && input <= RANGE_END;
    }
}
