package nextstep.week2.component;

/**
 * 숫자 계산 결과 처리
 * <pre>
 *   - strike count 및 ball count
 *   - 게임 종료 로직
 * </pre>
 */
public record Judgement(int strikeCount, int ballCount) {

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
