package module;

public enum Operator {
  SUM("+"),
  SUBSTRACT("-"),
  DIVIDE("/"),
  MULTIPLY("*");

  private String operator;

  Operator(String operator) {
    this.operator = operator;
  }

}
