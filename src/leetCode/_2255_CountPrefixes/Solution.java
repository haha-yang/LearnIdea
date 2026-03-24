package leetCode._2255_CountPrefixes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public int countPrefixes(String[] words, String s) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        int k = 1;
        while (k <= len) {
            map.put(s.substring(0, k), 0);
            k ++;
        }
        int n = words.length;
        k = 0;
        while (k < n) {
            if (map.containsKey(words[k])) {
                map.put(words[k], map.get(words[k]) + 1);
            }
            k ++;
        }
        int count = 0;
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            count += map.get(key);
        }
        return count;
    }
}