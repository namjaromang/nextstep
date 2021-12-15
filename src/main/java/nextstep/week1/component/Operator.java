package nextstep.week1.component;

public enum Operator implements IOperator {

  PLUS("+"),
  MINUS("-"),
  MULTIPLY("*"),
  DIVIDE("/");

  private final String operator;

  Operator(String operator) {
    this.operator = operator;
  }

  public static Operator of(String operator) {
    for (Operator value : values()) {
      if (value.getOperator().equals(operator)) {
        return value;
      }
    }
    return null;
  }

  public String getOperator() {
    return this.operator;
  }

  @Override
  public int operate(int arg1, int arg2) {
    return switch (this) {
      case PLUS -> arg1 + arg2;
      case MINUS -> arg1 - arg2;
      case DIVIDE -> arg1 / arg2;
      case MULTIPLY -> arg1 * arg2;
    };
  }
}
