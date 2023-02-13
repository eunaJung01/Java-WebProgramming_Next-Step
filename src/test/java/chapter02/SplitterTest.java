package chapter02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SplitterTest {

    @Test
    void 문자분리_기본구분자_콤마() {
        String input = "1,2";
        Assertions.assertThat(Splitter.separate(input)).isEqualTo(Arrays.asList("1", "2"));
    }

    @Test
    void 문자분리_기본구분자_콜론() {
        String input = "1:2";
        Assertions.assertThat(Splitter.separate(input)).isEqualTo(Arrays.asList("1", "2"));
    }

}
