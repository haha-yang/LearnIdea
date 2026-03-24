package leetCode._3335_LengthAfterTransformations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int lengthAfterTransformations(String s, int t) {
        if (s == null) return 0;
        else if (t == 0) return s.length();
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] amount = new int[26];
        for (int i = 0; i < n; i ++) {
            amount[s.charAt(i) - 'a'] ++;
        }
        int mod = t % 26;
        int count = t / 26;
        int[] temp = new int[26];
        for (int j = 0; j < 26; j ++) {
            int x = (j + mod) % 26;
            if (j + mod >= 26) {
                temp[x] += amount[j];
                temp[x + 1] += amount[j];
            } else {
                temp[x] += amount[j];
            }
        }
        System.arraycopy(temp, 0, amount, 0, 26);
        for (int i = 0; i < count; i ++) {
            for (int j = 0; j < 26; j ++) {
                if (amount[j] > 0) {
                    amount[j] ++;
                }
            }
            amount[1] ++;
        }
        long sum = 0;
        for (int i : amount) {
            sum += i;
            sum = sum % 1000000007;
        }
        return (int)sum;
    }
}