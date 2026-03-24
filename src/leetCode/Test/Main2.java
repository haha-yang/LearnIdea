package leetCode.Test;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        int n = Integer.parseInt(s1);
        int[] nums = new int[n];
        String s2 = in.nextLine();
        String[] arrS = s2.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arrS[i]);
        }
        Main2 main = new Main2();
        main.calculate(n, nums);
    }

    public void calculate(int n, int[] nums) {
        if (n == 1) {
            System.out.println(nums[0]);
            return;
        } else if (n == 2) {
            int sum = nums[0] + nums[1];
            System.out.println(nums[0] + " " + sum + " " + nums[1]);
        }
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        List<TreeNode> result = new ArrayList<>();
        TreeNode sum = new TreeNode(nums[0] + nums[1]);
        sum.height = 2;
        sum.left = new TreeNode(nums[0]);
        sum.right = new TreeNode(nums[1]);
        int k = 2;
        result.add(sum);
        calculate(nums, 2, result);
        TreeNode head = getHead(result);
        List<Integer> list = new ArrayList<>();
        getList(head, list);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(list.get(0));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    private void getList(TreeNode head, List<Integer> list) {
        if (head == null) return;
        if (head.left != null) {
            getList(head.left, list);
        }
        list.add(head.x);
        if (head.right != null) {
            getList(head.right, list);
        }
    }

    private TreeNode getHead(List<TreeNode> list) {
        if (list == null || list.size() == 0) return null;
        else if (list.size() == 1) return list.get(0);
        TreeNode node1 = list.get(0);
        list.remove(0);
        TreeNode node2 = list.get(1);
        list.remove(1);
        TreeNode sum = new TreeNode(node1.x + node2.x);
        sum.left = node1;
        sum.right = node2;
        sum.calculatHeight();
        calculateList(list, sum);
        return getHead(list);
    }

    private void calculate(int[] nums, int k, List<TreeNode> list) {
        int n = nums.length;
        if (k >= n) return;
        TreeNode head;
        if (list == null || list.size() == 0) {
            head = null;
        } else {
            head = list.get(0);
            list.remove(0);
        }
        if (head != null && (head.x <= nums[k] || (k + 1 < n && (head.x < nums[k + 1] || head.x < nums[k] + nums[k + 1])))) {
            TreeNode left = new TreeNode(nums[k]);
            TreeNode temp = new TreeNode(nums[k] + head.x);
            temp.left = left;
            temp.right = head;
            temp.calculatHeight();
            calculateList(list, temp);
            calculate(nums, k + 1, list);
        } else if (k + 1 < n){
            TreeNode left = new TreeNode(nums[k]);
            TreeNode right = new TreeNode(nums[k + 1]);
            TreeNode root = new TreeNode(nums[k] + nums[k + 1]);
            root.left = left;
            root.right = right;
            root.calculatHeight();
            calculateList(list, root);
            calculate(nums, k + 2, list);
        }
    }

    public void calculateList(List<TreeNode> list, TreeNode temp) {
        if (temp == null) return;
        if (list == null || list.size() == 0) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(temp);
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNode cur = list.get(0);
            if (temp.x < cur.x) {
                list.add(i, temp);
                break;
            } else if (temp.x == cur.x) {
                if (temp.height < cur.height) {
                    list.add(i, temp);
                }
            }
        }
    }

    class TreeNode {
        int x;
        int height = 1;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            x = value;
        }

        public int calculatHeight() {
            return Math.max(left == null ? 0 : left.height, right == null ? 0 : right.height);
        }
    }
}
