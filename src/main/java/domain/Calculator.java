package domain;

import java.util.Arrays;
import java.util.EnumMap;

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

    private final String operand;
    private static EnumMap<Calculator, String> CACHED;


    abstract int calculate(int a, int b);

    static {
        Arrays.stream(Calculator.values()).forEach(i -> CACHED.put(i, i.getOperand()));
    }

    Calculator(final String operand) {
        this.operand = operand;
    }

    public int calculate(){
        return 0;
    }

    public String getOperand() {
        return operand;
    }
}
