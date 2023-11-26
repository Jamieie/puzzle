package puzzle.view;

import puzzle.domain.Puzzle;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printTitle() {
        System.out.println("재미있는 15 퍼즐!");
    }

    public void printPuzzle(int turn, Puzzle puzzle) {
        System.out.println();
        System.out.println("Turn " + turn);
        Map<Integer, List<Integer>> numbers = puzzle.getNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            printRow(numbers.get(i));
        }
    }

    private void printRow(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 10){
                System.out.print("[ " + number + "]");
            }
            if (number >= 10 && number < 16) {
                System.out.print("[" + number + "]");
            }
            if (number == 16) {
                System.out.print("[  ]");
            }
        }
        System.out.println();
    }

    public void printSuccess(int turn) {
        System.out.println();
        System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성했습니다!");
    }
}
