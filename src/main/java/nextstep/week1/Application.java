package nextstep.week1;

import java.util.logging.Level;
import java.util.logging.Logger;
import nextstep.week1.component.Calculator;

public class Application {

  private static final Logger log = Logger.getLogger(Application.class.getName());

  public static void main(String[] args) throws Exception {
    log.log(Level.INFO, String.valueOf(Calculator.calculate("1 + 1")));
    log.log(Level.INFO, String.valueOf(Calculator.calculate("2 + 3 * 4 / 2")));
  }
}
