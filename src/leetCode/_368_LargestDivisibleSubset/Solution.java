package leetCode._368_LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int n = nums.length;
        Arrays.sort(nums);
        int[][] countArray = new int[n + 1][n + 1];
        int[] maxCountArray = new int[n];
        for (int i = 1; i <= n; i ++) {
            countArray[i][0] = 1;
            maxCountArray[i - 1] = 1;
        }
        int k = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (nums[i] % nums[j] == 0) {
                    countArray[i + 1][j + 1] = maxCountArray[j] + 1;
                } else {
                    countArray[i + 1][j + 1] = 1;
                }
                maxCountArray[i] = Math.max(maxCountArray[i], countArray[i + 1][j + 1]);
            }
            if (maxCount < maxCountArray[i]) {
                k = i;
                maxCount = maxCountArray[i];
            }
        }
        int amount = maxCount;
        while (k >= 0) {
            int i = k - 1;
            while (i >= 0) {
                if (nums[k] % nums[i] == 0 && countArray[k + 1][i + 1] == amount) {
                    amount --;
                    break;
                }
                i --;
            }
            result.add(nums[k]);
            k = i;
        }
        return result;
    }
}