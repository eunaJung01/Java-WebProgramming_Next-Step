package chapter02;

import chapter02.string_calculator.util.Splitter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SplitterTest {

    String input;

    @Test
    void 문자분리_기본구분자_콤마() {
        input = "1,2";
        Assertions.assertThat(Splitter.splitInput(input)).isEqualTo(Arrays.asList("1", "2"));
    }

    @Test
    void 문자분리_기본구분자_콜론() {
        input = "1:2";
        Assertions.assertThat(Splitter.splitInput(input)).isEqualTo(Arrays.asList("1", "2"));
    }

    @Test
    void 문자분리_커스텀구분자() {
        input = "//;\n1;2";
        Assertions.assertThat(Splitter.splitInput(input)).isEqualTo(Arrays.asList("1", "2"));
    }

}
