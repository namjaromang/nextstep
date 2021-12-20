package nextstep.week2.component;

public class Judgement {

  private final int strikeCount;
  private final int ballCount;

  public Judgement(int strikeCount, int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public int getStrikeCount() {
    return this.strikeCount;
  }

  public int getBallCount() {
    return this.ballCount;
  }

  public boolean isOut() {
    return strikeCount >= 3;
  }
}
