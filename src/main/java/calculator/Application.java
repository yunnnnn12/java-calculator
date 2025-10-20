package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {
    public static int splitAndSum(String customDeli, String input) {
        StringTokenizer str = new StringTokenizer(input, customDeli);
        int sum = 0;

        while (str.hasMoreTokens()) {
            String token = str.nextToken().trim();
            if (!token.isEmpty()) {
                try {
                    int num = Integer.parseInt(token);
                    if (num < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }

        return sum;
    }


    public static void main (String[]args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String firstLine = Console.readLine();
        String delimiter = ",:";
        int result;

        if (firstLine.startsWith(" ")) {
            char customDeli = firstLine.charAt(2);
            String secondLine = Console.readLine();

            String completedDeli = String.valueOf(customDeli) + delimiter;
            result = splitAndSum(completedDeli, secondLine);
        } else {
            result = splitAndSum(delimiter, firstLine);
        }

        System.out.printf("결과 : %d%n", result);
    }
}
