package leetCode._1123_LcaDeepestLeaves;

import leetCode.baseStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> equalTreeNodeList = new ArrayList<>();
        List<TreeNode> arrayDeque = new ArrayList<>();
        int k = 0;
        TreeNode curNode = root;
        int maxHigh = 0;
        TreeNode equalNode = null;
        while (curNode != null || !arrayDeque.isEmpty()) {
            if (curNode != null) {
                arrayDeque.add(curNode);
                curNode = curNode.left;
            }

            if (curNode == null) {
                int size = arrayDeque.size();
                if (size > maxHigh) {
                    maxHigh = size;
                    equalTreeNodeList.clear();
                    equalTreeNodeList.addAll(arrayDeque);
                    equalNode = equalTreeNodeList.get(size - 1);
                } else if (size == maxHigh) {
                    k = Math.min(arrayDeque.size() - 1, equalTreeNodeList.size() - 1);
                    while (k >= 0 && arrayDeque.get(k) != equalTreeNodeList.get(k)) {
                        equalTreeNodeList.remove(k);
                        k --;
                    }
                    equalNode = equalTreeNodeList.get(k);
                }
                if (!arrayDeque.isEmpty()) {
                    k = arrayDeque.size() - 1;
                    while (k >= 0 || curNode == null) {
                        curNode = arrayDeque.remove(k);
                        TreeNode lastNode = null;
                        if (!arrayDeque.isEmpty()) {
                            lastNode = arrayDeque.get(k - 1);
                        }
                        if (lastNode == null) {
                            curNode = null;
                            break;
                        } else if (lastNode.right != curNode) {
                            curNode = lastNode.right;
                            break;
                        } else {
                            k --;
                        }
                    }
                }
            }
        }
        return equalNode;
    }
}