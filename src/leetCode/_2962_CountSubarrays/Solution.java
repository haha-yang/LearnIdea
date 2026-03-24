package leetCode._2962_CountSubarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return 0;
        int n = nums.length;
        int max = 0;
        List<Integer> maxIndexList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (max < nums[i]) {
                maxIndexList.clear();
                maxIndexList.add(i);
                max = nums[i];
            } else if (max == nums[i]) {
                maxIndexList.add(i);
            }
        }
        int size = maxIndexList.size();
        if (size < k) return 0;
        int i = 0;
        int j = 0;
        int lastI = -1;
        long count = 0;
        while (i <size && j < size) {
            while (j < size && (j - i + 1) < k) {
                j ++;
            }
            if (j == size) {
                break;
            }
            count += ((long)(maxIndexList.get(i) - lastI) * (n - maxIndexList.get(j)));
            lastI = maxIndexList.get(i);
            i ++;
        }
        return count;
    }
}