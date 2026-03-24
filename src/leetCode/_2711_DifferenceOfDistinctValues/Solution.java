package leetCode._2711_DifferenceOfDistinctValues;

import java.util.HashSet;

public class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        if (grid == null || grid[0] == null) return null;
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int topLeft = calculateDifferenceCount(i, j, grid, -1);
                int bottomRight = calculateDifferenceCount(i, j, grid, 1);
                result[i][j] = Math.abs(topLeft - bottomRight);
                result[n - 1 - i][m - 1 - j] = result[i][j];
            }
        }
        return result;
    }

    private int calculateDifferenceCount(int i, int j, int[][] grid, int difference) {
        HashSet<Integer> differenceCountSet = new HashSet<>();
        int r = i;
        int c = j;
        int n = grid.length;
        int m = grid[0].length;
        while (r + difference >= 0 && r + difference < n && c + difference >= 0 && c + difference < m) {
            differenceCountSet.add(grid[r + difference][c + difference]);
            r += difference;
            c += difference;
        }
        return differenceCountSet.size();
    }
}