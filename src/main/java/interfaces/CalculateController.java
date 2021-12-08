package interfaces;

import application.CalculateService;
import interfaces.dto.CalculatorRequest;

public class CalculateController {

    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    public void calculate(CalculatorRequest calculatorRequest) {
        calculateService.calculate();
    }
}
