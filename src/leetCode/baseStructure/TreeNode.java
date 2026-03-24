package leetCode.baseStructure;

import java.util.ArrayDeque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTreeNode(String s) {
        if (s == null || s.length() == 0) return null;
        String[] strArray = s.split(",");
        int n = strArray.length;
        if (n == 0) return null;
        if (strArray[0].startsWith("[")) {
            strArray[0] = strArray[0].substring(1);
        }
        if (strArray[n - 1].endsWith("]")) {
            strArray[n - 1] = strArray[n - 1].substring(0, strArray[n - 1].length() - 1);
        }
        TreeNode[] array = new TreeNode[n];
        int k = 0;
        TreeNode head = null;
        while (k < n) {
            Integer temp = strArray[k].equals("null") ? null : Integer.parseInt(strArray[k]);
            if (temp == null) {
                k ++;
                continue;
            }
            if (k == 0) {
                array[k] = new TreeNode(temp);
                head = array[k];
            } else {
                array[k] = new TreeNode(temp);
                int lastIndex = (k - 1)/2;
                if (k % 2 == 1) {
                    array[lastIndex].left = array[k];
                } else {
                    array[lastIndex].right = array[k];
                }
            }
            k ++;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode curNode = this;
        while (curNode != null || !arrayDeque.isEmpty()) {
            if (curNode != null) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(curNode.val);
            }
            if (curNode != null) {
                if (curNode.left != null) {
                    arrayDeque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    arrayDeque.offer(curNode.right);
                }
            }
            if (!arrayDeque.isEmpty()) {
                curNode = arrayDeque.poll();
            } else {
                curNode = null;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
