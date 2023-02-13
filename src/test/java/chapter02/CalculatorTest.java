package chapter02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    final Calculator calculator = new Calculator();

    @Test
    void 더하기() {
        List<Integer> numbers = Arrays.asList(1, 2);
        assertThat(calculator.add(numbers)).isEqualTo(3);
    }

}
