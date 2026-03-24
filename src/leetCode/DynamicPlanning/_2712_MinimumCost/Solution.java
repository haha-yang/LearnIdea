package leetCode.DynamicPlanning._2712_MinimumCost;

public class Solution {
    public long minimumCost(String s) {
        if (s == null || s.length() <= 1) return 0;
        int n = s.length();
        long[][] lastCount = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i --) {
            if (s.charAt(i) == '0') {
                lastCount[i][0] = Math.min(lastCount[i + 1][0], lastCount[i + 1][1] + n - i - 1);
                lastCount[i][1] = Math.min(lastCount[i + 1][0] + n - i, lastCount[i + 1][1] + n - i + n - i - 1);
            } else {
                lastCount[i][0] = Math.min(lastCount[i + 1][0] + n - i - 1 + n - i, lastCount[i + 1][1] + n - i);
                lastCount[i][1] = Math.min(lastCount[i + 1][0] + n - i - 1, lastCount[i + 1][1]);
            }
        }
        long[][] preCount = new long[n + 1][2];
        preCount[0][0] = 0;
        preCount[0][1] = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) == '0') {
                preCount[i + 1][0] = Math.min(preCount[i][0], preCount[i][1] + i);
                preCount[i + 1][1] = Math.min(preCount[i][0] + i + 1, preCount[i][1] + i + i + 1);
            } else {
                preCount[i + 1][0] = Math.min(preCount[i][0] + i + i + 1, preCount[i][1] + i + 1);
                preCount[i + 1][1] = Math.min(preCount[i][0] + i, preCount[i][1]);
            }
            res = Math.min(res, Math.min(preCount[i + 1][0] + lastCount[i][0], preCount[i + 1][1] + lastCount[i][1]));
        }
        return res;
    }
}