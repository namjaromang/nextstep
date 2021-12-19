package Game;

public class BaseballGame implements Game{


  private User user;
  private Computer computer;
  private Referee referee;

  @Override
  public void start() {
    this.user = User.generate();
    this.computer = Computer.generate();
    this.referee = Referee.generate();

    while(true) {
      user.input();
      referee.judge(user.getBalls(), computer.getBalls());

      if (referee.calledOut()) {
        break;
      }
    }
  }

}
