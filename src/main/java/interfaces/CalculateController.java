package interfaces;

import domain.Calculator;
import interfaces.dto.CalculatorRequest;
import interfaces.dto.CalculatorResponse;

public class CalculateController {

    public CalculatorResponse calculate(CalculatorRequest calculatorRequest) {
       int sum = Calculator.calculate(calculatorRequest.getNumbers(), calculatorRequest.getOperators());
       return new CalculatorResponse(sum);
    }
}
