package chapter02.string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Converter {

    final static String nonNumber_regex = "[^0-9]";

    public static List<Integer> convert(List<String> numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            addNumber(numbers, numberString);
        }
        return numbers;
    }

    private static void addNumber(List<Integer> numbers, String numberString) {
        if (numberString.equals("")) {
            numbers.add(0);
            return;
        }
        if (!isIllegalNumber(numberString)) {
            numbers.add(Integer.parseInt(numberString));
        }
    }

    private static boolean isIllegalNumber(String numberString) {
        if (numberString.contains("-") || Pattern.compile(nonNumber_regex).matcher(numberString).find()) {
            throw new RuntimeException();
        }
        return false;
    }

}
