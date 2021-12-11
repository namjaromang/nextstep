package interfaces;

import interfaces.dto.CalculatorRequest;
import interfaces.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ClientInputTest {

    @DisplayName("사용자가 정상적으로 계산기 문장을 입력하였을 때 객체 생성")
    @ParameterizedTest
    @CsvSource(value = "3 + 5 * 2 - 1")
    public void successInput(String input) {
        //Given && When
        CalculatorRequest request = CalculatorRequest.input(input);

        //Then
        List<Integer> expectNumbers = setNumbers(input);
        List<String> expectOperators = setOperators(input);

        assertAll(
                () -> assertThat(request).isNotNull(),
                () -> assertThat(request.getNumbers().equals(expectNumbers)).isTrue(),
                () -> assertThat(request.getOperators().equals(expectOperators)).isTrue()
        );
    }

    private List<String> setOperators(String input) {
        String[] separate = input.split(" ");
        return IntStream.range(0, separate.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> separate[i])
                .collect(Collectors.toList());
    }

    private List<Integer> setNumbers(String input) {
        String[] separate = input.split(" ");
        return IntStream.range(0, separate.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(separate[i]))
                .collect(Collectors.toList());
    }

    @DisplayName("빈값을 입력하였을 때 예외처리")
    @ParameterizedTest
    @EmptySource
    public void emptyInput(String input) {
        assertThatThrownBy(() -> {
            CalculatorRequest.input(input);
        }).isInstanceOf(BadRequestException.class);
    }

    @DisplayName("숫자와 연산자 조합이 불규칙할 경우 예외처리 ")
    @ParameterizedTest
    @CsvSource(value = {"+ ", " 2", "2 + 2 + ", "+ + + + +"})
    public void invalidInput(String input){
        assertThatThrownBy(() -> {
            CalculatorRequest.input(input);
        }).isInstanceOf(BadRequestException.class);
    }
}
