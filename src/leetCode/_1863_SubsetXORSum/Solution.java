package leetCode._1863_SubsetXORSum;

import java.util.ArrayDeque;

public class Solution {
    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int k = 0;
        int xorSum = 0;
        while (k < n || !list.isEmpty()) {
            if (k < n) {
                xorSum ^= nums[k];
                sum += xorSum;
            }
            if (k >= n) {
                while (!list.isEmpty() && k >= n) {
                    int temp = list.pop();
                    xorSum ^= nums[temp];
                    k = temp + 1;
                }
            } else {
                list.push(k);
                k ++;
            }
        }
        return sum;
    }
}