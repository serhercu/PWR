package lab12;

import java.util.Scanner;

public class LinesReader {
    String concatLines(int howMany, Scanner scanner) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < howMany; i++) {
            result.append(scanner.nextLine());
        }
        return result.toString();
    }

}