package Game;

import java.util.Scanner;

public class User {

  private String balls;

  public static User generate() {
    return new User();
  }

  public void input() {
    Scanner scanner = new Scanner(System.in);
    this.balls = scanner.nextLine();
  }

  public String getBalls() {
    return balls;
  }
}
