package puzzle.domain;

import java.util.*;

public class NumberGenerator {
    private final int PUZZLE_SIZE = 16;
    private final int LIST_SIZE = 4;
    private final int MAP_SIZE = 4;
    private List<Integer> allNumbers;

    public NumberGenerator() {
        createNumbers();
    }

    private void createNumbers() {
        allNumbers = new ArrayList<>();
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            allNumbers.add(i+1);
        }
        Collections.shuffle(allNumbers);
    }

    public Map<Integer, List<Integer>> createLists() {
        Map<Integer, List<Integer>> lists = new HashMap<>();
        for (int i = 0; i < MAP_SIZE; i++) {
            lists.put(i, createList());
        }
        return lists;
    }

    private List<Integer> createList() {
        List<Integer> rowNumbers = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            rowNumbers.add(allNumbers.get(0));
            allNumbers.remove(0);
        }
        return rowNumbers;
    }
}
