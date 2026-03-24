package leetCode._2829_MinimumSum;

public class Solution {
    public int minimumSum(int n, int k) {
        int result = (1 + n) * n /2;
        int half = k/2;
        if (n <= half) {
            return result;
        }
        result = (1 + half) * half / 2 + (n - half) * (k + k + n - half - 1) / 2;
        return result;
    }
}