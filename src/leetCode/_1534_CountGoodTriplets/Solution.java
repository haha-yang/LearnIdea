package leetCode._1534_CountGoodTriplets;

import java.util.*;

public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        Map<Integer, List<Integer>> diffLastMap = new HashMap<>();
        for (int i = 1; i < n - 1; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    List<Integer> list = diffLastMap.get(i);
                    if (list == null) {
                        list = new ArrayList<>();
                        diffLastMap.put(i, list);
                    }
                    list.add(j);
                }
            }
        }
        Map<Integer, List<Integer>> diffNextMap = new HashMap<>();
        for (int i = 1; i < n - 1; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (Math.abs(arr[i] - arr[j]) <= b) {
                    List<Integer> list = diffNextMap.get(i);
                    if (list == null) {
                        list = new ArrayList<>();
                        diffNextMap.put(i, list);
                    }
                    list.add(j);
                }
            }
        }
        int count = 0;
        for (int key : diffLastMap.keySet()) {
            List<Integer> diffNextList = diffNextMap.get(key);
            if (diffNextList == null) {
                continue;
            }
            List<Integer> diffLastList = diffLastMap.get(key);
            for (int i : diffLastList) {
                for (int j : diffNextList) {
                    if (Math.abs(arr[i] - arr[j]) < c) {
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}