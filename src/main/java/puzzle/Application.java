package puzzle;

import puzzle.domain.NumberGenerator;
import puzzle.domain.Puzzle;
import puzzle.util.Validation;
import puzzle.view.InputView;
import puzzle.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printTitle();

        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.createNumbers();
        Puzzle puzzle = new Puzzle(numbers);

        int turn = 0;
        boolean result = false;
        while (!result) {
            turn++;
            outputView.printResult(turn, puzzle.getNumbers());

            List<Integer> input = askNumber();
            puzzle.swap(input);
            result = puzzle.isSorted();
        }
        outputView.printSuccess(turn);
    }

    private static List<Integer> askNumber() {
        InputView inputView = new InputView();
        List<Integer> input;
        while (true) {
            try {
                input = inputView.readInput();
                validateNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private static void validateNumbers(List<Integer> inputNumbers) {
        Validation validation = new Validation();
        if (!validation.isInRange(inputNumbers) || validation.hasDuplicate(inputNumbers)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 다시 입력해 주세요.");
        }
    }
}