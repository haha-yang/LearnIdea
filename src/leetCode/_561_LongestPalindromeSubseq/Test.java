package leetCode._561_LongestPalindromeSubseq;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    private final Scanner scanner = new Scanner(System.in);

    public void test() {

        do {
            System.out.println("输入数据");
            String s = inputGeneralStringNoBlank();
            scanner.close();
            System.out.println("s = " + s);
            Solution solution = new Solution();
            System.out.println(solution.longestPalindromeSubseq(s));
        } while (!Objects.equals(scanner.nextLine(), "nihao"));
        scanner.close();
    }

    private String inputGeneralStringNoBlank() {
        String s = scanner.nextLine();
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        int blank_index = s.indexOf(' ');
        if (blank_index == -1) return s;
        return s.substring(0, blank_index);
    }
}
