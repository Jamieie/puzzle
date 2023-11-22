package puzzle.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<InputView> askNumbers() {
        System.out.println("교환할 두 숫자를 입력>");
        String input = readLine();
        return null;
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
