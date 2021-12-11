package domain;

import domain.exception.UnsupportedOperatorTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void calculate(List<Integer> numbers, List<String> operators, int result) {
        //When
        int expect = Calculator.calculate(numbers, operators);

        //Then
        assertThat(expect).isEqualTo(result);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(List.of(1,3,5), List.of("+","+","+"), 9),
                Arguments.of(List.of(2,2,4,5,4), List.of("*","-","+","-"), 1),
                Arguments.of(List.of(10,100,500,10), List.of("*","/","+","-"), 12)
        );
    }

    @DisplayName("정의되지 않는 연산자가 포함되어있는 경우 예외처리")
    @ParameterizedTest
    @MethodSource("provideParametersInvalid")
    public void inValidOperatorType(List<Integer> numbers, List<String> operators) {
        assertThatThrownBy(() ->
            Calculator.calculate(numbers, operators)
        ).isInstanceOf(UnsupportedOperatorTypeException.class);
    }

    private static Stream<Arguments> provideParametersInvalid() {
        return Stream.of(
                Arguments.of(List.of(1,3,5), List.of("+","^","+")),
                Arguments.of(List.of(2,2,4,5,4), List.of("*","%","+","-")),
                Arguments.of(List.of(10,100,500,10), List.of("*","@","+","-"))
        );
    }
}
