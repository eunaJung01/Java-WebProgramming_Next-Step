package chapter02;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static List<String> separate(String input) {
        List<String> numbers = Arrays.asList(input.split(",|:"));
        return numbers;
    }

}
