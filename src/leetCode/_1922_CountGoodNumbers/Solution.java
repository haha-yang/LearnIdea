package leetCode._1922_CountGoodNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int countGoodNumbers(long n) {
        if (n == 0) return 0;
        else if (n == 1) return 5;
        long mod = 1000000007;
        long half = n/2;
        long leaving = n - n/2;
        boolean isEven = n % 2 == 0;
        long sum = isEven ? 1 : 5;
        long count = a(20, 1, half, mod);
        sum *= powMultify(20, 1, half % count, mod);
        return (int)(sum % mod);
    }

    private long a(long baseValue, long startValue, long k, long mod) {
        long tempPow = 20;
        long count = 1;
        while (tempPow != startValue) {
            tempPow *= baseValue;
            tempPow %= mod;
            count ++;
        }
        return count;
    }

    private long powMultify(long baseValue, long sum, long k, long mod) {
        long tempPow = 1;
        long count = 0;
        while (tempPow > 0 && tempPow < Long.MAX_VALUE) {
            tempPow *= baseValue;
            count ++;
        }
        long halfCount = count/2;
        sum *= ((long) Math.pow(baseValue, k % halfCount) % mod);
        long kCount = k / halfCount;
        if (kCount == 0) return sum % mod;
        return powMultify(((long)Math.pow(baseValue, halfCount)) % mod, sum, kCount, mod);
    }
}