import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator implements Icalculator {

  @Override
  public BigDecimal add(BigDecimal x, BigDecimal y) {
    return x.add(y);
  }

  @Override
  public BigDecimal substract(BigDecimal x, BigDecimal y) {
    return x.subtract(y);
  }

  @Override
  public BigDecimal multiply(BigDecimal x, BigDecimal y) {
    return x.multiply(y);
  }

  @Override
  public BigDecimal divide(BigDecimal x, BigDecimal y) {
    return x.divide(y);
  }

  @Override
  public String orderGuarantee(String input) {
    String[] inputSplit = input.split(" ");
    Queue<String> queue = new LinkedList<String>();
    for (String inputValue : inputSplit) {
      queue.offer(inputValue);
    }
    return queue.poll();
  }

}
