package Game;

public class Computer {

  private String balls;

  public Computer() {
    this.balls = generateRandomBall();
  }

  public static Computer generate() {
    return new Computer();
  }

  private String generateRandomBall() {
    return "123";
  }

  public String getBalls() {
    return balls;
  }
}
