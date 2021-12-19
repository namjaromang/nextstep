package baseball;

import baseball.computer.Computer;
import baseball.computer.IComputer;
import baseball.user.IUser;
import baseball.user.User;
import java.io.IOException;

public class Baseball {

  public static void main(String[] args) {
    IComputer computer = new Computer();
    IUser user = new User();
    computer.initialize();
    boolean isCorrect = false;
    while (!isCorrect) {
      printInputMessage();
      try {
        isCorrect = computer.checkAndPrint(user.getInput());
      } catch (IOException ignored) {
      }
    }

  }

  public static void printInputMessage() {
    System.out.print("숫자를 입력해 주세요 : ");
  }
}
