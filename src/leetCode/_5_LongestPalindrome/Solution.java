package leetCode._5_LongestPalindrome;

import java.util.List;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        else if (s.length() == 0) return "";
        int n = s.length();
        int maxLength = 1;
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < n; i ++) {
            int end = i + 1;
            char c = s.charAt(i);
            while (end < n) {
                int index = s.indexOf(c, end);
                if (index == -1) break;
                boolean isFind = find(s.substring(i, index + 1));
                if (isFind) {
                    if (index + 1 - i > maxLength) {
                        maxStr = s.substring(i, index + 1);
                        maxLength = index + 1 - i;
                    }
                }
                end = index + 1;
            }
        }
        return maxStr;
    }

    private boolean find(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start ++;
            end --;
        }
        return start > end;
    }
}