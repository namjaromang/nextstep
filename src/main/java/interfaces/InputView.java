package interfaces;

import interfaces.dto.NumberRequest;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUMBER_COMMENT = "숫자를 입력해주세요 : ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_NUMBER_COMMENT);
        String inputRaw = scanner.nextLine();

    }
}
