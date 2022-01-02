package computer;

public interface IComputer {

  abstract int[] getRandomNumber();

  abstract String getBallInfo(int[] userNumber, int[] randomNumber);
}
