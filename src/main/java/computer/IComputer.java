package computer;

import java.util.Set;

public interface IComputer {

  abstract int[] getRandomNumber();

  abstract String getBallInfo(int[] userNumber, int[] randomNumber);
}
