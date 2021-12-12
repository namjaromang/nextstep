import java.math.BigDecimal;
import java.util.Queue;

public interface Icalculator {

  public abstract BigDecimal add(BigDecimal x, BigDecimal y);

  public abstract BigDecimal substract(BigDecimal x, BigDecimal y);

  public abstract BigDecimal multiply(BigDecimal x, BigDecimal y);

  public abstract BigDecimal divide(BigDecimal x, BigDecimal y);

  public abstract String orderGuarantee(String input);
}
