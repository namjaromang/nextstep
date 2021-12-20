package nextstep.week2.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseBallCalculatorTest {

  BaseBallCalculator baseBallCalculator;

  @BeforeEach
  void setup() {
    this.baseBallCalculator = new BaseBallCalculator();
  }

  @Test
  void strike_when_position_and_value_matched() {
    Integer number = 123;
    Integer guess = 145;
    Judgement result = baseBallCalculator.calculate(number, guess);
    assertEquals(result.getStrikeCount(), 1);
  }

  @Test
  void ball_when_value_matched_and_position_not_matched() {
    Integer number = 123;
    Integer guess = 451;
    Judgement result = baseBallCalculator.calculate(number, guess);
    assertEquals(result.getBallCount(), 1);
  }
}