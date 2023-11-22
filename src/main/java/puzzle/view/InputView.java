package puzzle.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> askNumbers() {
        System.out.println("교환할 두 숫자를 입력>");
        String input = readLine();

        if (hasSpaceAtStart(input) || !isTwoValues(input)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumbers = new ArrayList<>();
        try {
            inputNumbers = toIntegers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return inputNumbers;
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private List<Integer> toIntegers(String input) {
        return Arrays.stream(input.trim().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean hasSpaceAtStart(String input) {
        String[] split = input.split("");
        return split[0] == " ";
    }

    private boolean isTwoValues(String input) {
        return input.split(",").length == 2;
    }
}
