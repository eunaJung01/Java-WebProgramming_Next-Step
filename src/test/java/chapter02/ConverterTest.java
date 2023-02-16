package chapter02;

import chapter02.string_calculator.util.Converter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @Test
    void 문자열배열을_숫자배열로_변환() {
        assertThat(Converter.convert(Arrays.asList("1", "2"))).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    void 문자열배열을_숫자배열로_변환_에러_숫자X() {
        assertThatThrownBy(() -> Converter.convert(Arrays.asList("냐", "!")))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자열배열을_숫자배열로_변환_에러_음수() {
        assertThatThrownBy(() -> Converter.convert(Arrays.asList("-1", "-2")))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자열배열을_숫자배열로_변환_공백_테스트() {
        assertThat(Converter.convert(Arrays.asList("", "1"))).isEqualTo(Arrays.asList(0, 1));
    }

}
