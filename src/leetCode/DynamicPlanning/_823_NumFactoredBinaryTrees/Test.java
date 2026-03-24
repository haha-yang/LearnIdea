package leetCode.DynamicPlanning._823_NumFactoredBinaryTrees;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test {
    private final Scanner scanner = new Scanner(System.in);

    public void test() {
        int[] s = inputGeneralArray();
        scanner.close();
        Solution solution = new Solution();
        System.out.println(solution.numFactoredBinaryTrees(s));
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

    private int[] inputGeneralArray() {
        String s = scanner.nextLine();
        try {
            if (s == null || s.length() == 0) return new int[0];
            String[] arrStr = s.split(" ");
            List<Integer> list = new ArrayList<>();
            for (String value : arrStr) {
                try {
                    if (value == null || value.length() == 0) {
                        continue;
                    }
                    int temp = Integer.parseInt(value);
                    list.add(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void outputPrintList(List<Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private void outputPrintSet(Set<Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
