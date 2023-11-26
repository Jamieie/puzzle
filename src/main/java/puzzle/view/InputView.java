package puzzle.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public int readLine() {
        System.out.print("숫자 입력> ");
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 다시 입력해 주세요.");
        }
        return input;
    }
}
