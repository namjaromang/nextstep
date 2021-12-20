package nextstep.week2.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberBaseBallTest {

  private NumberBaseBall numberBaseBall;

  @Test
  void has_number_100_to_1000_when_created() {
    Assertions.assertNotNull(numberBaseBall.getNumber());
    Assertions.assertTrue(numberBaseBall.getNumber() >= 100);
    Assertions.assertTrue(numberBaseBall.getNumber() < 1000);
  }

  @Test
  void required_input_when_play_begin() {
    Integer input = numberBaseBall.start();
    Assertions.assertNotNull(input);
  }

  @Test
  void finish_when_three_strike() {
    Integer input = numberBaseBall.start();
    Integer number = numberBaseBall.getNumber();
    Judgement judgement = numberBaseBall.judge(number);
    Assertions.assertTrue(judgement.isOut());
    Assertions.assertTrue(numberBaseBall.isWin());
  }

  @Test
  void finish_when_10_times_over() {
    Integer input = numberBaseBall.play();
    Assertions.assertNotNull(input);
  }

  @BeforeEach
  void setup() {
    this.numberBaseBall = new NumberBaseBall();
  }

}
