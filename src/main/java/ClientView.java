import interfaces.CalculateController;
import interfaces.dto.CalculatorRequest;
import interfaces.dto.CalculatorResponse;

import java.util.Scanner;

public class ClientView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        String input = SCANNER.nextLine();

        CalculateController calculateController = new CalculateController();
        CalculatorResponse response = calculateController.calculate(CalculatorRequest.input(input));

        System.out.println(response.getSum());
    }
}
