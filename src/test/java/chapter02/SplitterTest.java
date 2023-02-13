package chapter02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SplitterTest {

    Splitter splitter;
    String input;

    @BeforeEach
    void setup() {
        splitter = new Splitter();
    }

    @Test
    void 문자분리_기본구분자_콤마() {
        input = "1,2";
        Assertions.assertThat(splitter.splitInput(input)).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    void 문자분리_기본구분자_콜론() {
        input = "1:2";
        Assertions.assertThat(splitter.splitInput(input)).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    void 문자분리_커스텀구분자() {
        input = "//;\n1;2";
        Assertions.assertThat(splitter.splitInput(input)).isEqualTo(new String[]{"1", "2"});
    }

}
