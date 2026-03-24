package leetCode._1278_PalindromePartition;

import java.util.Scanner;

public class Test {
    private final Scanner scanner = new Scanner(System.in);

    public void test() {
        String s = inputGeneralStringNoBlank();
        int k = inputInteger();
        scanner.close();
        System.out.println("s = " + s + ", k = " + k);
        leetCode._1278_PalindromePartition.Solution solution = new leetCode._1278_PalindromePartition.Solution();
        System.out.println(solution.palindromePartition(s, k));
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

    private int inputInteger() {
        try {
            String s = scanner.nextLine();
            if (s == null || s.length() == 0) {
                return 0;
            }
            s = s.trim();
            int blank_index = s.indexOf(' ');
            if (blank_index == -1) return Integer.parseInt(s);
            return Integer.parseInt(s.substring(0, blank_index));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
