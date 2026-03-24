package leetCode._131_Partition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> maxSubList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s == null || s.length() == 0) return lists;
        int len = s.length();
        int palindromicLen = 1;
        while (palindromicLen <= len) {
            List<String> subList = new ArrayList<>();
            subList.add("a");
            lists.add(subList);
            palindromicLen ++;
        }
        System.out.println(PalindromicMaxLen(s));
        return lists;
    }

    private int PalindromicMaxLen(String s) {
        int maxLen = 0;
        if (s == null || s.length() == 0) return maxLen;
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            int start = i;
            int end = len - 1;
            int count = 0;
            while (end >= start) {
                if (end - start < maxLen) {
                    break;
                }
                while (s.charAt(start) != s.charAt(end)) {
                    end --;
                }
                while (start <= end && s.charAt(start) == s.charAt(end)) {
                    if (start == end) {
                        count ++;
                    } else {
                        count += 2;
                    }
                    start ++;
                    end --;
                }
                if (start > end) {
                    int leftCount = count/2;
                    if (start - end == 2) {
                        leftCount ++;
                    }
                    if (maxLen <= count) {
                        maxSubList.add(s.substring(start - leftCount, end + leftCount + 1));
                    }
                    maxLen = Math.max(maxLen, count);
                } else if (s.charAt(start) != s.charAt(end)) {
                    start -= count/2;
                    end += count/2;
                    count = 0;
                }
                end --;
            }
        }
        return maxLen;
    }
}