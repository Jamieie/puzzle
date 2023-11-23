package puzzle.view;

import java.util.List;

public class OutputView {
    public void printTitle() {
        System.out.println("간단 숫자 퍼즐");
    }

    public void printPuzzle(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printTurn(int turnCount) {
        System.out.println("Turn " + turnCount);
    }

    public void printSuccess(int turnCount) {
        System.out.println("축하합니다! " + turnCount +"턴만에 퍼즐을 완성하셨습니다!");
    }
}
