package leetCode._2302_CountSubarrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return 0;
        int n = nums.length;
        long count = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        long sum = 0;
        while (i < n || !deque.isEmpty()) {
            int size = deque.size();
            int j = i;
            while (j < n && (sum + nums[j]) * (size + 1) < k) {
                deque.offer(nums[j]);
                count ++;
                sum += nums[j];
                size = deque.size();
                j ++;
            }
            if (!deque.isEmpty()) {
                sum -= deque.pop();
                if (!deque.isEmpty()) {
                    count += deque.size();
                }
            }
            if (j < n && sum == 0 && nums[j] >= k) {
                j ++;
            }
            i = j;
        }
        return count;
    }
}