package leetCode._464;

public class _464_3_MaxValue {

    public static void main(String[] args) {
        _464_3_MaxValue t = new _464_3_MaxValue();
        int[] nums = {2,3,4,5,1,2,3,6};
        t.maxValue(nums);
    }

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int k = 0;
        int maxValue = 0;
        int minValue = 1000000000;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        int lastMinValue = 1000000000;
        int lastMinIndex = -1;
        int lastMaxValue = 1;
        int lastMaxIndex = -1;
        int maxLeft = 0;
        while (k < n) {
            if (nums[k] >= maxLeft) {
                maxLeft = nums[k];
            }
            int curValue = nums[k];
            int curIndex = k;
            result[k] = nums[k];
            if (curValue <= maxLeft) {
                result[k] = maxLeft;
                if (maxLeft == maxValue) {
                    k++;
                    continue;
                }
            }
            if (k < lastMaxIndex && lastMinIndex != -1 && curValue > lastMinValue) {
                result[k] = lastMaxValue;
                k ++;
                continue;
            }
            int i = k + 1;
            int j = n - 1;
            int maxTemp = result[k];
            int maxTempIndex = k;
            int minTemp = 1000000000;
            int minTempIndex = -1;
            while (i < j) {
                while (i < j && curValue <= nums[j])
                    j --;
                while (i < j && nums[i] <= nums[j])
                    i ++;
                if (i < j) {
                    maxTemp = nums[i];
                    maxTempIndex = i;
                    minTemp = nums[j];
                    minTempIndex = j;
                    i ++;
                    while (i < j) {
                        if (nums[i] > maxTemp) {
                            maxTempIndex = i;
                            maxTemp = nums[i];
                        }
                        i ++;
                    }
                }
            }
            if (maxTemp > result[k]) {
                result[k] = maxTemp;
                lastMaxValue = maxTemp;
                lastMaxIndex = maxTempIndex;
                if (minTempIndex != -1) {
                    lastMinValue = minTemp;
                    lastMinIndex = minTempIndex;
                }
            }
            k ++;
        }
        return result;
    }
}
