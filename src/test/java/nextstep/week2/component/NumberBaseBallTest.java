package nextstep.week2.component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NumberBaseBallTest {

  private NumberBaseBall numberBaseBall;
  private Referee referee;

  @Test
  void has_number_100_to_1000_when_created() {
    Assertions.assertNotNull(numberBaseBall.getNumber());
    Assertions.assertTrue(numberBaseBall.getNumber() >= 100);
    Assertions.assertTrue(numberBaseBall.getNumber() < 1000);
  }

  @Test
  void print_text_and_return_input_when_read_number()
      throws NoSuchFieldException, IllegalAccessException {
    Integer inputNumber = numberBaseBall.getNumber();
    InputStream stdin = System.in;
    String inputString = inputNumber.toString() + "\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    PrintStream stdout = System.out;
    System.setOut(ps);

    mockScanner(numberBaseBall);

    Integer input = numberBaseBall.readNumber();

    System.setIn(stdin);
    System.setOut(stdout);

    String outputText = byteArrayOutputStream.toString();

    Assertions.assertEquals("숫자를 입력해 주세요 : ", outputText);
    Assertions.assertEquals(inputNumber, input);
  }

  @Test
  void win_the_game_when_three_strike_out() {
    Mockito.when(referee.isOut()).thenReturn(true);
    Assertions.assertTrue(numberBaseBall.isWin());
  }

  @Test
  void continue_when_choose_1()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    String inputString = "1\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    PrintStream stdout = System.out;
    System.setOut(ps);

    mockScanner(numberBaseBall);

    Method method = NumberBaseBall.class.getDeclaredMethod("askContinue");
    method.setAccessible(true);
    boolean cont = (Boolean) method.invoke(numberBaseBall);

    Assertions.assertTrue(cont);
    Assertions.assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", byteArrayOutputStream.toString());
  }

  @BeforeEach
  void setup() throws NoSuchFieldException, IllegalAccessException {
    this.numberBaseBall = new NumberBaseBall();
    this.referee = Mockito.mock(Referee.class);
    Field f1 = numberBaseBall.getClass().getDeclaredField("referee");
    f1.setAccessible(true);
    f1.set(numberBaseBall, referee);
  }


  private void mockScanner(NumberBaseBall numberBaseBall)
      throws NoSuchFieldException, IllegalAccessException {
    Field field = NumberBaseBall.class.getDeclaredField("scanner");
    field.setAccessible(true);
    field.set(numberBaseBall, new Scanner(System.in));
  }
}
