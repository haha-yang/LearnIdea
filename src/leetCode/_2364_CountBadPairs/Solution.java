package leetCode._2364_CountBadPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long count = (n - 1) * n / 2;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            int temp = nums[i] - i;
            if (map.keySet().contains(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, (long)1);
            }
        }
        for (int key : map.keySet()) {
            long value = map.get(key);
            if (value > 1) {
                count -= ((value * (value - 1)) / 2);
            }
        }
        return count;
    }
}