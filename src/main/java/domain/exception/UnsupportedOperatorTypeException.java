package domain.exception;

public class UnsupportedOperatorTypeException extends RuntimeException{

    private static final String MESSAGE = "은 지원되지 않는 타입입니다.";

    public UnsupportedOperatorTypeException(String operatorType) {
        super(operatorType + MESSAGE);
    }
}
