package nextstep.week2.component;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 숫자야구 심판 클래스
 * <pre>
 *   - 판정 계산기 및 판정 이력 관리
 *   - 정답과 무관하게 입력된 값으로만 판단
 * </pre>
 */
public class Referee {

  private final Deque<Judgement> judgements = new ArrayDeque<>();
  private final BaseBallCalculator baseBallCalculator = new BaseBallCalculator();

  public void reset() {
    judgements.clear();
  }

  public void judge(int number, int guess) {
    Judgement judgement = baseBallCalculator.calculate(number, guess);
    judgements.add(judgement);
  }

  public int judgeCount() {
    return judgements.size();
  }

  public void call() {
    // TODO: judgement 근거하여 볼, 스크라이크, 게임종료 메시지 출력
    throw new UnsupportedOperationException();
  }

  public boolean isOut() {
    return judgements.stream().anyMatch(Judgement::isOut);
  }
}
