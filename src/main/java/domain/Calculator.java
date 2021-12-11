package domain;

import domain.exception.UnsupportedOperatorTypeException;

import java.util.Arrays;
import java.util.List;

public enum Calculator {

    SUM("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    private final String operator;


    abstract int calculate(int a, int b);


    Calculator(final String operator) {
        this.operator = operator;
    }

    public static int calculate(List<Integer> numbers, List<String> operators) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(i == 0) {
                sum = numbers.get(i);
            }
            if (i <= operators.size() && i != 0) {
                sum = findOperatorCalculator(operators.get(i - 1)).calculate(sum, numbers.get(i));
            }
        }
        return sum;
    }

    private static Calculator findOperatorCalculator(String operator){
        return Arrays.stream(Calculator.values())
                .filter((i) -> i.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperatorTypeException(operator));
    }

    public String getOperator() {
        return operator;
    }
}
