import java.util.LinkedList;
import java.util.Queue;
import module.Calculator;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();
        Queue<String> operators = new LinkedList<>();

        //파싱

        Calculator calculator = new Calculator();
        calculator.calculate(1,2,"*");
    }

}