package chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Converter {

    final String nonNumber_regex = "[^0-9]";

    List<Integer> numbers;

    public List<Integer> convert(List<String> numberStrings) {
        numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            addNumber(numberString);
        }
        return numbers;
    }

    private void addNumber(String numberString) {
        if (!isIllegalNumber(numberString)) {
            numbers.add(Integer.parseInt(numberString));
        }
    }

    private boolean isIllegalNumber(String numberString) {
        if (numberString.contains("-") || Pattern.compile(nonNumber_regex).matcher(numberString).find()) {
            throw new RuntimeException();
        }
        return false;
    }

}
