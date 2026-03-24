package leetCode._740_DeleteAndEarn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int[][] count = new int[n][2];
        int k = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i ++) {
            int num = nums[i];
            Integer index = map.get(num);
            if (index == null) {
                map.put(num, k);
                index = k ++;
            }
            count[index][0] = num;
            count[index][1] ++;
            if (count[maxIndex][1] < count[index][1]) {
                maxIndex = index;
            }
        }
        int sum = calculateSum(count, map, maxIndex);
        while (!map.isEmpty()) {
            maxIndex = getMaxCountIndex(count, map);
            if (maxIndex == -1) break;
            sum += calculateSum(count, map, maxIndex);
        }
        return sum;
    }

    private int getMaxCountIndex(int[][] count, Map<Integer, Integer> map) {
        if (map.isEmpty()) return -1;
        int n = count.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i ++) {
            if (count[i][1] > count[maxIndex][1]) {
                maxIndex = i;
            }
        }
        return count[maxIndex][0] == 0 ? -1 : maxIndex;
    }

    private int calculateSum(int[][] count, Map<Integer, Integer> map, int maxIndex) {
        if (maxIndex == -1) return 0;
        int sum = count[maxIndex][0] * count[maxIndex][1];
        count[maxIndex][1] = 0;
        map.remove(count[maxIndex][0]);
        Integer preValue = map.get(count[maxIndex][0] - 1);
        Integer nextValue = map.get(count[maxIndex][0] + 1);
        if (preValue != null) {
            count[preValue][1] = 0;
            map.remove(count[maxIndex][0] - 1);
        }
        if (preValue != null) {
            count[nextValue][1] = 0;
            map.remove(count[maxIndex][0] + 1);
        }
        return sum;
    }
}