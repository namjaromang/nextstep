package nextstep.week1;

import nextstep.week1.component.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  @Test
  void positive_plus() throws Exception {
    Assertions.assertEquals(3, Calculator.calculate("1 + 2"));
    Assertions.assertEquals(14, Calculator.calculate("3 + 2 + 4 + 5"));
    Assertions.assertEquals(9156, Calculator.calculate("11 + 22 + 9123"));
  }

  @Test
  void complex() throws Exception {
    Assertions.assertEquals(10, Calculator.calculate("2 + 3 * 4 / 2"));
  }
}