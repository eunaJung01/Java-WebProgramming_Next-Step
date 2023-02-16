package chapter02.string_calculator;

import java.util.List;

public class Calculator {

    public static int add(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }

}
