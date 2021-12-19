package baseball.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User implements IUser{

  @Override
  public Integer[] getInput() throws IOException {
    char[] charArray = new char[3];
    Integer[] input = new Integer[3];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.read(charArray, 0, 3);
    for (int i = 0; i < 3; i++) {
      input[i] = Integer.valueOf(String.valueOf(charArray[i]));
    }
    return input;
  }

}
