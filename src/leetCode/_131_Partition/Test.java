package leetCode._131_Partition;

import java.util.Scanner;

public class Test {
    private final Scanner scanner = new Scanner(System.in);

    public void test() {
        String s = inputGeneralStringNoBlank();
        scanner.close();
        System.out.println("s = " + s);
        Solution solution = new Solution();
        System.out.println(solution.partition(s));
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
