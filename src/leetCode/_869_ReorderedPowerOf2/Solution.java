package leetCode._869_ReorderedPowerOf2;

class Solution {
    private int[] array = new int[10];

    public boolean reorderedPowerOf2(int n) {
        int temp = n;
        while (temp > 0) {
            array[temp % 10] ++;
            temp /= 10;
        }
        int minValue = getMinValue();
        int maxValue = getMaxValue();
        int lastPow = 1;
        int lastPowIndex = 0;
        int nextPow = 1;
        int nextPowIndex = 0;
        while (nextPow <= maxValue) {
            while (nextPow < minValue) {
                lastPow = nextPow;
                lastPowIndex = nextPowIndex;
                nextPow *= 2;
                nextPowIndex ++;
            }
            if (nextPow < maxValue) {
                nextPow *= 2;
                nextPowIndex ++;
            } else if (nextPow == maxValue) {
                return true;
            }
        }
        while (lastPow <= nextPow) {
            while (lastPow < minValue) {
                lastPow *= 2;
            }
            if (lastPow > maxValue) {
                break;
            }
            boolean isEqual = isEqual(array, calculateValue(lastPow));
            if (isEqual) return true;
            lastPow *= 2;
        }
        return false;
    }

    private int[] calculateValue(int value) {
        int[] temp = new int[10];
        while (value > 0) {
            temp[value % 10] ++;
            value /= 10;
        }
        return temp;
    }

    private boolean isEqual(int[] sourceArray, int[] array) {
        int sourceN = sourceArray.length;
        int n = array.length;
        if (sourceN != n) return false;
        int k = 0;
        while (k < n) {
            if (sourceArray[k] == array[k]) {
                k ++;
            } else {
                return false;
            }
        }
        return true;
    }

    private int getMinValue() {
        int[] temp = new int[10];
        System.arraycopy(array, 0, temp, 0, 10);
        int result = 0;
        int k = 1;
        while (k < 10) {
            if (temp[k] > 0) {
                temp[k] --;
                result = k;
                break;
            } else {
                k ++;
            }
        }
        k = 0;
        while (k < 10) {
            while (temp[k] > 0) {
                result = result * 10 + k;
                temp[k] --;
            }
            k ++;
        }
        return result;
    }

    private int getMaxValue() {
        int[] temp = new int[10];
        System.arraycopy(array, 0, temp, 0, 10);
        int result = 0;
        int k = 9;
        while (k >= 0) {
            if (temp[k] > 0) {
                temp[k] --;
                result = k;
                break;
            } else {
                k --;
            }
        }
        k = 9;
        while (k >= 0) {
            while (temp[k] > 0) {
                result = result * 10 + k;
                temp[k] --;
            }
            k --;
        }
        return result;
    }
}