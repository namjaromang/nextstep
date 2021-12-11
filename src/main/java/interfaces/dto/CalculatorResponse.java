package interfaces.dto;

public class CalculatorResponse {

    private final int sum;

    public CalculatorResponse(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
