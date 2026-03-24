package leetCode._2787_NumberOfWays;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] array = null;
    private int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        double cbrt = Math.cbrt(n);
        int maxValue = (int)cbrt;
        if (maxValue < cbrt) {
            maxValue ++;
        }
        int m = maxValue;
        array = new int[m + 1];
        return calculate(n, x, maxValue);
    }

    private int calculate(int n, int x, int maxValue) {
        int amount = 0;
        int k = maxValue;
        int left = n;
        while (left > 0) {
            int temp = pow(k, x);
            left -= temp;
        }
        return amount;
    }

    private int pow(int value, int x) {
        if (array[value] != 0) {
            return array[value];
        }
        long result = 1L;
        int k = 0;
        while (k < x) {
            result = (result * value) % MOD;
            k ++;
        }
        array[value] = (int) result;
        return array[value];
    }
}