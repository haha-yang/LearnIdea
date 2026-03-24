package leetCode._790_NumTilings;

public class Solution {
    private long[] nums = null;

    public int numTilings(int n) {
        if (n < 0) return 0;
        if (nums == null) {
            nums = new long[n + 1];
            nums[0] = 0;
            nums[1] = 1;
            if (n >= 2) {
                nums[2] = 2;
            }
        }
        if (n == 0 || nums[n] != 0) return (int)nums[n];
        int count = numTilings(n - 1) + numTilings(n - 2) + numTilings(n - 3) + 2;
        if (n >= 4) {
            count += numTilings(n - 5) + numTilings(n - 4) + 1;
        }
        nums[n] = count % 1000000007;
        return (int)nums[n];
    }
}