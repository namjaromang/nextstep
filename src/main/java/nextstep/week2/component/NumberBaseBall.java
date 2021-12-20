package nextstep.week2.component;

import java.util.Random;

public class NumberBaseBall {

  private final BaseBallCalculator calculator = new BaseBallCalculator();
  private Integer number;
  private boolean win = false;
  private int ballCount = 0;
  public NumberBaseBall() {
    number = new Random().nextInt(100, 1000);
  }

  public void reset() {
    this.win = false;
    this.ballCount = 0;
    this.number = new Random().nextInt(100, 1000);
  }

  public Integer getNumber() {
    return number;
  }

  public Integer play() {
    throw new UnsupportedOperationException();
  }

  public Integer start() {
    throw new UnsupportedOperationException();
  }

  public Judgement judge(Integer number) {
    ballCount++;
    throw new UnsupportedOperationException();
  }

  public boolean isWin() {
    return win;
  }

  public boolean isGameOver() {
    return ballCount > 10;
  }
}
