package leetCode._120_MinimumTotal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        if (n == 1) return triangle.get(0).get(0);
        int[] sum = new int[m];
        sum[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        int lastSum = sum[0];
        for (int i = 1; i < m; i ++) {
            sum[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i ++) {//[[2],[3,4],[6,5,7],[4,1,8,3]]
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j ++) {
                int temp = sum[j];
                if (j == 0) {
                    min = Integer.MAX_VALUE;
                    lastSum = sum[1];
                }
                sum[j] = Math.min(lastSum, sum[j]) + triangle.get(i).get(j);
                lastSum = temp;
                min = Math.min(sum[j], min);
            }
        }
        return min;
    }
}