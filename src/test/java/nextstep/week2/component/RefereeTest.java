package nextstep.week2.component;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {

  @Test
  void judge() {
    Referee referee = new Referee();
    Assertions.assertEquals(0, referee.judgeCount());
    Assertions.assertThrows(UnsupportedOperationException.class, () -> referee.judge(123, 123));
//    Assertions.assertEquals(1, referee.judgeCount());
  }

  @Test
  void call() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    Referee referee = new Referee();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> referee.judge(123, 123));
//    System.setOut(printStream);
//    referee.call();
//
//    Assertions.assertEquals("", outputStream.toString());
  }

}