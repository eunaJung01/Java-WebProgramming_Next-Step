package chapter02.string_calculator.util;

import java.util.List;

public class Calculator {

    public static int add(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }

}
