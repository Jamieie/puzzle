package puzzle.view;

import java.util.List;

public class OutputView {
    public void printTitle() {
        System.out.println("간단 숫자 퍼즐");
    }

    public void printResult(int turn, List<Integer> numbers) {
        System.out.println("Turn " + turn);
        System.out.println(numbers);
    }

    public void printSuccess(int turn) {
        System.out.println("축하합니다! " + turn +"턴만에 퍼즐을 완성하셨습니다!");
    }
}
