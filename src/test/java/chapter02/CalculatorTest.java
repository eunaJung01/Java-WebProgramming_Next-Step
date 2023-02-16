package chapter02;

import chapter02.string_calculator.util.Calculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void 더하기() {
        List<Integer> numbers = Arrays.asList(1, 2);
        assertThat(Calculator.add(numbers)).isEqualTo(3);
    }

}
