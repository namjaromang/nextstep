package nextstep.week2.component;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 숫자야구 게임 관리 클래스
 * <pre>
 *   - 게임의 시작 / 종료 / 재시작 관리
 *   - 게임 시작 시 정답 숫자 생성
 * </pre>
 */
public class NumberBaseBall {

  private final Scanner scanner = new Scanner(System.in);
  private final Referee referee = new Referee();
  private final Deque<Integer> userInputs = new ArrayDeque<>();

  private Integer number;

  public NumberBaseBall() {
    reset();
  }

  public void reset() {
    this.number = NumberGenerator.generateNumber();
    this.referee.reset();
    this.userInputs.clear();
  }

  Integer getNumber() {
    return number;
  }

  public void play() {
    while (!isGameEnd()) {
      playInning();
    }
  }

  private boolean isGameEnd() {
    boolean end = false;
    if (isWin()) {
      end = askContinue();
    }
    return end;
  }

  private boolean askContinue() {
    while (true) {
      try {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String ask = scanner.nextLine();
        return validateAsk(ask);
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  public void playInning() {
    int guess = readNumber();
    referee.judge(number, guess);
    referee.call();
  }

  public Integer readNumber() {
    Integer input = null;
    while (scanner.hasNextLine()) {
      try {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputString = scanner.nextLine();
        userInputs.add(validateNumber(inputString));
        input = userInputs.getLast();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
    return input;
  }

  public boolean isWin() {
    return referee.isOut();
  }

  private int validateNumber(String number) throws Exception {
    char[] numberArray = number.toCharArray();
    Arrays.sort(numberArray);
    String sorted = String.valueOf(numberArray);
    Matcher redundantMather = Pattern.compile("(([1-9])\\2+)").matcher(sorted);
    Matcher digitMatcher = Pattern.compile("^[1-9]{3}$").matcher(sorted);
    if (redundantMather.find() || !digitMatcher.find()) {
      throw new Exception("서로 다른 세자리 숫자만 입력 가능합니다.");
    }
    return Integer.parseInt(number);
  }

  private boolean validateAsk(String ask) throws Exception {
    if ("1".equals(ask)) {
      return true;
    }
    if ("2".equals(ask)) {
      return false;
    }
    throw new Exception("1 또는 2만 입력 가능합니다.");
  }
}
