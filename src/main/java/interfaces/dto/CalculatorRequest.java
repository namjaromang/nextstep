package interfaces.dto;

import interfaces.exception.BadRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorRequest {

    private static final String WHITE_SPACE = " ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private List<Integer> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    private CalculatorRequest(String[] input){
        if(isBlank(input) || validInputLength(input) || invalidPattern(input)) {
            throw new BadRequestException("잘못입력하셨습니다.");
        }
        setSeparateNumberAndOperator(input);
    }

    private void setSeparateNumberAndOperator(String[] input) {
        for(int i = 0; i < input.length; i++) {
            if(i % 2 == 0) {
                numbers.add(Integer.parseInt(input[i]));
            } else {
                operators.add(input[i]);
            }
        }
    }

    private boolean invalidPattern(String[] input) {
        int index = 0;
        while(index <= input.length) {
            if(index % 2 == 0 && !NUMBER_PATTERN.matcher(input[index]).matches()) {
                return true;
            }
            index++;
        }
        return false;
    }


    private boolean validInputLength(String[] input) {
        return input.length == 1 || input.length % 2 == 0;
    }

    public static CalculatorRequest input(String input) {
        String[] separate = input.split(WHITE_SPACE);
        return new CalculatorRequest(separate);
    }

    private boolean isBlank(String[] input) {
        return input == null || input.length == 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getOperators() {
        return operators;
    }
}
