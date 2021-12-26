package nextstep.week2.component;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

  @Test
  void generate() {
    int round = 20;
    Set<Integer> numSets = new HashSet<>();
    for (int i = 0; i < round; i++) {
      int number = NumberGenerator.generateNumber();
      Assertions.assertTrue(number >= 100 && number <= 999);
      System.out.println(number);
      numSets.add(number);
    }

    Assertions.assertEquals(round, numSets.size());
  }

}