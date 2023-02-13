package chapter02;

import java.util.List;

public class Calculator {

    public int add(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }

}
