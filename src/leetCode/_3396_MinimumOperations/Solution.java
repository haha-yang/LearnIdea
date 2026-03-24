package leetCode._3396_MinimumOperations;

import java.util.*;

public class Solution {
    public int minimumOperations(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        Set<Integer> isContainSet = new HashSet<>();
        int leaving = n % 3;
        boolean isLeaving = leaving != 0;
        int count = n / 3 + (isLeaving ? 1 : 0);
        int k = n - 1;
        while (leaving > 0 && k >= 0) {
            if (isContainSet.contains(nums[k])) {
                return count;
            }
            isContainSet.add(nums[k]);
            leaving --;
            k --;
        }
        if (isLeaving) {
            count --;
        }
        while (k >= 0) {
            if (isContainSet.contains(nums[k])) {
                break;
            }
            isContainSet.add(nums[k]);
            if (k % 3 == 0) {
                count --;
            }
            k --;
        }
        return count;
    }
}