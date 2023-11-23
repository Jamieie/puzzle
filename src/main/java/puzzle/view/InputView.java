package puzzle.view;

import puzzle.util.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> readInput() {
        System.out.println("교환할 두 숫자를 입력>");
        String input = readLine();

        validate(input);

        List<Integer> inputNumbers;
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

    private void validate(String input) {
        Validation validation = new Validation();
        if (validation.hasSpaceAtStart(input) || !validation.hasOneComma(input)) {
            throw new IllegalArgumentException();
        }
    }
}
