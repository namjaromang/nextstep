package user;

import java.util.Scanner;

public class User implements IUser {

  /**
   * 사용자 요청값 저장 리턴 메소드
   *
   * @return
   */
  @Override
  public int[] setUserNumber() {
    String userNumber;
    int[] number = new int[3];

    Scanner scanner = new Scanner(System.in);
    userNumber = scanner.nextLine();
    //todo 스트링을 int[]로 어떻게할까?

    return number;
  }
}