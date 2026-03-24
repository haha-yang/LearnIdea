package leetCode._2255_CountPrefixes;

import java.util.Scanner;

public class Test {
    private final Scanner scanner = new Scanner(System.in);

    public void test() {
        String[] words = inputArrayString();
        String s = inputGeneralStringNoBlank();
        scanner.close();
        Solution solution = new Solution();
        int result = solution.countPrefixes(words, s);
        System.out.println("计算后结果");
        System.out.println(result);
    }

    private String[] inputArrayString() {
        String s = scanner.nextLine();
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        s = s.trim();
        String[] result = s.split(" ");
        return result;
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

    private int[][] inputArray() {
        try {
            String s = scanner.nextLine();
            if (s == null || s.length() == 0) {
                return null;
            }
            s = s.trim();
            String[] sArray = s.split(" ");
            int length = sArray.length;
            if (length < 2) return null;
            int n = Integer.parseInt(sArray[0]);
            int m = Integer.parseInt(sArray[1]);
            if (n <= 0 || m <= 0) return null;
            int[][] result = new int[n][m];
            for (int i = 0; i < n; i ++) {
                String sub = scanner.nextLine();
                String[] subArray = sub.split(" ");
                int min = Math.min(subArray.length, m);
                for (int j = 0; j < min; j ++) {
                    int temp = 0;
                    try {
                        temp = Integer.parseInt(subArray[j]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    result[i][j] = temp;
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void printArray(int[][] result) {
        if (result == null || result[0].length == 0) {
            System.out.println("空数组");
            return;
        }
        int n = result.length;
        int m = result[0].length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
