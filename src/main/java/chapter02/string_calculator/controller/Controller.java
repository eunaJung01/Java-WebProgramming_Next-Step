package chapter02.string_calculator.controller;

import chapter02.string_calculator.util.Calculator;
import chapter02.string_calculator.util.Converter;
import chapter02.string_calculator.util.Splitter;
import chapter02.string_calculator.view.InputView;
import chapter02.string_calculator.view.OutputView;

import java.util.List;

public class Controller {

    public static void runStringCalculator() {
        List<String> input = Splitter.splitInput(InputView.readInput());
        List<Integer> numbers = Converter.convert(input);
        int result = Calculator.add(numbers);
        OutputView.printResult_add(result);
    }

}
