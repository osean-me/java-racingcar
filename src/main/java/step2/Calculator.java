package step2;

import static step2.Operator.validateOperator;
import static step2.Operator.getOperator;

public class Calculator {

    private static final String DELIMITER = " ";

    public static int calculate(String input) {
        validateEmptyInput(input);

        String[] operation = input.split(DELIMITER);
        int result = Integer.parseInt(operation[0]);

        for (int i = 2; i < operation.length; i += 2) {
            validateOperator(operation[i - 1]);
            Operator operator = getOperator(operation[i - 1]);
            result = operator.calculate(result, Integer.parseInt(operation[i]));
        }
        return result;
    }

    private static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}