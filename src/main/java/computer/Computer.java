package computer;

public class Computer implements IComputer {

  /**
   * 1~9 사이 랜덤 값 저장 및 리턴 메소드
   *
   * @return
   */
  @Override
  public int[] getRandomNumber() {
    int[] randomNumber = new int[3];
    for (int i = 0; i < randomNumber.length; i++) {
      double number = Math.random();
      randomNumber[i] = (int) (number * 10);
      if (randomNumber[0] == 0) {
        randomNumber[0] = (int) (int) (number * 10);
      }
    }
    return randomNumber;
  }

  /**
   * 유저가 요청한 볼값의 정보를 리턴 하는 메소드
   *
   * @return
   */
  @Override
  public String getBallInfo(int[] userNumber, int[] randomNumber) {
    int strike = 0;
    int ball = 0;
    int out = 0;
    int threeOut = 0;

    for (int i = 0; i < userNumber.length; i++) {
      for (int j = 0; j < userNumber.length; j++) {
        if (randomNumber[i] == userNumber[j]) {
          if (i == j) {
            strike++;
          } else {
            ball++;
          }
        }
      }

      if (strike == 0 && ball == 0) {
        out++;
        threeOut++;
      }

      if (out == 3) {
        return "3아웃 게임종료";
      }

      if (strike == 3) {
        return "3스트라이크 승리";
      }
      strike = 0;
      ball = 0;
      out = 0;
    }

    return String.format("%d 스트라이트 %d 볼 %d 아웃", strike, ball, out);
  }


  //todo 만들고  나서보니 숫자야구게임의 시작과 종료관리를 위한로직이없었다..
}