package nextstep.week1.component;

import java.util.Stack;

public class Calculator {

  private static final Stack<Integer> numberStack = new Stack<>();
  private static final Stack<Operator> operatorStack = new Stack<>();

  public static int calculate(String expression) throws Exception {
    String[] args = expression.split("\\s+");
    for (int i = 0; i < args.length; i++) {
      if (i % 2 == 0) {
        try {
          int number = Integer.parseInt(args[i]);
          if (numberStack.isEmpty()) {
            numberStack.push(number);
          } else {
            Operator operator = operatorStack.pop();
            int prev = numberStack.pop();
            int result = operator.operate(prev, number);
            numberStack.push(result);
          }
        } catch (NumberFormatException ex) {
          throw new Exception("argument is not number");
        }
      } else {
        Operator operator = Operator.of(args[i]);
        if (operator == null) {
          throw new Exception("unsupported operator");
        }
        operatorStack.push(operator);
      }
    }
    return numberStack.pop();
  }
}
