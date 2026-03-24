package leetCode._3337_LengthAfterTransformations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Solution main = new Solution();
        String[] arrS = s.split(" ");
        int n = arrS.length;
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i ++) {
            try {
                nums[i + 1] = Integer.parseInt(arrS[i]);
            } catch (Exception e) {
                nums[i] = 0;
            }
        }
        main.calculate(nums);
    }

    private void calculate(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        TreeNode root = calculate(nums, 1);
        List<Integer> list = new ArrayList<>();
        calculate(root, list);
        for (int i = 0; i < list.size(); i ++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    private TreeNode calculate(int[] nums, int i) {
        int n = nums.length;
        if (i >= n) return null;
        TreeNode root = new TreeNode(nums[i]);
        if (i * 2 <= n) {
            root.left = calculate(nums, i * 2);
        }
        if (i * 2 + 1 <= n) {
            root.right = calculate(nums, i * 2 + 1);
        }
        return root;
    }

    private void calculate(TreeNode root, List<Integer> list) {
        if (root == null || root.left == null) return;
        if (root.left != null) {
            calculate(root.left, list);
        }
        if (root.right != null) {
            calculate(root.right, list);
        }
        list.add(root.x);
    }

    private void calculate1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        calculate(nums, 1, n, list);
        for (int i = 0; i < list.size(); i ++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    private void calculate(int[] nums, int index, int lastEnd,
                           List<Integer> list) {
        int n = nums.length;
        if (index > lastEnd || index <= 0) return;
        int nextLeftIndex = index * 2;
        if (nextLeftIndex <= lastEnd || nextLeftIndex + 1 <= lastEnd) {
            calculate(nums, nextLeftIndex, lastEnd, list);
            calculate(nums, nextLeftIndex + 1, lastEnd, list);
            list.add(nums[index]);
        }
    }

    private int maxHeight(int n) {
        int height = 0;
        while (n > 0) {
            height ++;
            n /= 2;
        }
        return height;
    }

    class TreeNode {
        int x;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {
            x = value;
        }
    }
}