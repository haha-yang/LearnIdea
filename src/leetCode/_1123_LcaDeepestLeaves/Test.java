package leetCode._1123_LcaDeepestLeaves;

import leetCode.baseStructure.TreeNode;

import java.util.Scanner;

public class Test {
    private final Scanner scanner = new Scanner(System.in);

    public void test() {
        TreeNode s = inputGeneralStringObtainTreeNode();
        scanner.close();
        if (s != null) {
            System.out.println(s);
        }
        Solution solution = new Solution();
        TreeNode result = solution.lcaDeepestLeaves(s);
        if (result != null) {
            System.out.println(result);
        }
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

    private TreeNode inputGeneralStringObtainTreeNode() {
        try {
            String s = scanner.nextLine();
            if (s == null || s.length() == 0) {
                return null;
            }
            s = s.trim();
            return TreeNode.createTreeNode(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
