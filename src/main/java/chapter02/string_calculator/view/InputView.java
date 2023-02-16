package chapter02.string_calculator.view;

import java.util.Scanner;

public class InputView {

    public static String readInput() {
        System.out.println("입력 : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
