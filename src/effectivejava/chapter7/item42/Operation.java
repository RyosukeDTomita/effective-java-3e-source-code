package effectivejava.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

// Enum with function object fields & constant-specific behavior (Page 195)
public enum Operation {
  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  TIMES("*", (x, y) -> x * y),
  DIVIDE("/", (x, y) -> x / y);

  private final String symbol;
  private final DoubleBinaryOperator op;

  Operation(String symbol, DoubleBinaryOperator op) {
    this.symbol = symbol;
    this.op = op;
  }

  @Override
  public String toString() {
    return symbol;
  }

  public double apply(double x, double y) {
    return op.applyAsDouble(x, y);
  }

  public static void main(String[] args) {
    double x = 1.0;
    double y = 2.0;
    for (Operation op : Operation.values())
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
  }
}
