package chapter02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    final String defaultSeparatorForm_regex = ",|:";
    final String customSeparatorForm_regex = "//(.)\n(.*)";

    public String[] splitInput(String input) {
        Matcher matcher = Pattern.compile(customSeparatorForm_regex).matcher(input);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return input.split(defaultSeparatorForm_regex);
    }

}
