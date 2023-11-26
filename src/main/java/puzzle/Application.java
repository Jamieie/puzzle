package puzzle;

import puzzle.domain.NumberGenerator;
import puzzle.domain.Puzzle;
import puzzle.util.Validation;
import puzzle.view.InputView;
import puzzle.view.OutputView;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        Puzzle puzzle = new Puzzle(generator.createLists());

        OutputView outputView = new OutputView();
        outputView.printTitle();

        int turn = 1;
        outputView.printTurn(turn);
        outputView.printPuzzle(puzzle);

        boolean sorted = false;
        while (!sorted) {
            int number = askNumber(puzzle);
            puzzle.move(number);
            sorted = puzzle.isSorted();
            outputView.printTurn(turn);
            outputView.printPuzzle(puzzle);
            turn++;
        }
        outputView.printSuccess(turn);
    }

    private static int askNumber(Puzzle puzzle) {
        InputView inputView = new InputView();
        int input;
        while (true) {
            try {
                input = inputView.readLine();
                validate(puzzle, input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        return input;
    }

    private static void validate(Puzzle puzzle, int input) {
        Validation validation = new Validation();
        boolean inRange = validation.isInRange(input);
        boolean vacancyNear = puzzle.hasVacancyNear(input);
        if (!inRange && !vacancyNear) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 다시 입력해 주세요.");
        }
    }
}