import application.CalculateService;
import interfaces.CalculateController;
import interfaces.dto.CalculatorRequest;

import java.util.Scanner;

public class ClientView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        String input = SCANNER.nextLine();

        CalculateController calculateController = new CalculateController(new CalculateService());
        calculateController.calculate(CalculatorRequest.input(input));

    }
}
