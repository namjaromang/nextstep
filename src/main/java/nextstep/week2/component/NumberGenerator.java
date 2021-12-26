package nextstep.week2.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 숫자야구 정답 생성 클래스
 * <pre>
 *   - 중복되지 않는 1 ~ 9 로 구성된 세자리 숫자 생성
 * </pre>
 */
public class NumberGenerator {

  private static final List<String> seeds = Arrays
      .asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

  public static int generateNumber() {
    Collections.shuffle(seeds);
    return Integer.parseInt(String.join("", seeds.subList(0, 3)));
  }
}
