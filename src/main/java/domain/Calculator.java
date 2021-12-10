package domain;

import java.util.*;

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
    private static Map<String, Calculator> CACHED = new HashMap<>();


    abstract int calculate(int a, int b);

    static {
        Arrays.stream(Calculator.values()).forEach(i -> CACHED.put(i.getOperator(), i));
    }

    Calculator(final String operator) {
        this.operator = operator;
    }

    public static int calculate(List<Integer> number, List<String> operator){
        return 0;
    }

    public String getOperator() {
        return operator;
    }
}
