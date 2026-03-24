package leetCode.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        if (s == null || s.length() == 0 || t == 0 || nums.size() != 26) return 0;
        long[] arr = new long[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] ++;
        }
        // List<ArrayList<Integer>> nextIndexList = new ArrayList<ArrayList<Integer>>();
        // for (int i = 0; i < 26; i ++) {
        //     nextIndexList.add(new ArrayList<Integer>());
        // }
        // for (int i = 0; i < 26; i ++) {
        //     int end = i + nums.get(i);
        //     for (int j = i + 1; j <= end; j ++) {
        //         nextIndexList.get(j % 26).add(i);
        //     }
        // }
        long[][] singleTransformArr = new long[26][26];
        for (int i = 0; i < 26; i ++) {
            int end = i + nums.get(i);
            for (int j = i + 1; j <= end; j ++) {
                singleTransformArr[i][j % 26] = 1;
            }
        }
        int x = t;
        while (x > 0) {
            if (x % 2 != 0) {
                arr = singleTransformation(arr, singleTransformArr);
            }
            singleTransformArr = singleTransformation(singleTransformArr);
            x /= 2;
        }
        long sum = 0;
        for (long num : arr) {
            sum = (sum + num) % MOD;
        }
        return (int)sum;
    }

    private long[][] singleTransformation(long[][] singleTransformArr) {
        long[][] temp = new long[26][26];
        for (int i = 0; i < 26; i ++) {
            for (int j = 0; j < 26; j ++) {
                long sum = 0;
                for (int k = 0; k < 26; k ++) {
                    sum = (sum + singleTransformArr[i][k] * singleTransformArr[k][j]) % MOD;
                }
                temp[i][j] = sum;
            }
        }
        return temp;
    }

    private long[] singleTransformation(long[] arr, long[][] singleTransformArr) {
        long[] temp = new long[26];
        for (int i = 0; i < 26; i ++) {
            long sum = 0;
            for (int j = 0; j < 26; j++) {
                sum = (sum + arr[j] * singleTransformArr[j][i]) % MOD;
            }
            temp[i] = sum;
        }
        return temp;
    }

    private int[] singleTransformation(int[] arr, List<Integer> nums, List<ArrayList<Integer>> nextIndexList) {
        int[] temp = new int[26];
        for (int i = 0; i < 26; i ++) {
            int size = nextIndexList.get(i).size();
            for (int j = 0; j < size; j ++) {
                temp[i] = (temp[i] + arr[nextIndexList.get(i).get(j)]) % MOD;
            }
        }
        return temp;
    }
}