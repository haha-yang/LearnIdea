package leetCode._2176_CountPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int countPairs(int[] nums, int k) {
        if (nums == null || nums.length == 1 || k == 0) return 0;
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i], list);
            }
            list.add(i);
        }
        int count = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            int size = list.size();
            if (size < 2) continue;
            for (int i = 0; i < size - 1; i++) {
                if (list.get(i) % k == 0) {
                    count += (size - 1 - i);
                    continue;
                }
                for (int j = i + 1; j < size; j++) {
                    if (list.get(i) * list.get(j) % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}