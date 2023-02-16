package chapter02.string_calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    final static String defaultSeparatorForm_regex = ",|:";
    final static String customSeparatorForm_regex = "//(.)\n(.*)";

    public static List<String> splitInput(String input) {
        Matcher matcher = Pattern.compile(customSeparatorForm_regex).matcher(input);
        if (matcher.find()) {
            return Arrays.asList(matcher.group(2).split(matcher.group(1)));
        }
        return Arrays.asList(input.split(defaultSeparatorForm_regex));
    }

}
