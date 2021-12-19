package Game;

import java.util.Arrays;

public class Referee {

  private int strike = 0;
  private int ball = 0;

  public static Referee generate() {
    return new Referee();
  }

  public void judge(String userBalls, String computerBalls) {
    judgeInit();
    String[] userBallArray = split(userBalls);
    String[] computerBallArray = split(computerBalls);

    for (int i = 0; i < userBallArray.length; i++) {
      if (isStrike(userBallArray[i], computerBallArray[i])) {
        strike ++;
        continue;
      }
      for (int j = 0; j < computerBallArray.length; j++) {
        if (isBall(userBallArray[i], computerBallArray[j])) {
          ball++;
          break;
        }
      }
    }

    System.out.println(judgeResult());
  }

  private String judgeResult() {
    StringBuilder messageBuilder = new StringBuilder();
    if (this.ball != 0) {
      messageBuilder.append(this.ball+"볼 ");
    }
    if (this.strike != 0) {
      messageBuilder.append(this.strike+ "스트라이크");
    }
    return messageBuilder.toString();
  }

  private String[] split(String ball) {

    if (ball.length() != 3) {
      System.out.println(String.format("ball의 갯수를 다시 확인해주세요. 현재: %d개"));
    }

    return new String[3];
  }

  private boolean isStrike(String userBall, String computerBall) {
    return isEqual(userBall, computerBall);
  }

  private boolean isBall(String userBall, String computerBall) {
    return isEqual(userBall, computerBall);
  }

  private boolean isEqual(String userBall, String computerBall) {
    if (userBall == "" || userBall == null) {
      throw new IllegalArgumentException();
    }

    if (computerBall == "" || computerBall == null) {
      throw new IllegalArgumentException();
    }

    return userBall.equals(computerBall);
  }

  public boolean calledOut() {
    return this.strike == 3;
  }

  private void judgeInit() {
    this.strike = 0;
    this.ball = 0;
  }
}
