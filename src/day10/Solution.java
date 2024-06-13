package day10;

import java.util.Arrays;

public class Solution {
    /**
     * day 10
     * 1051. Height Checker (Easy)
     * Runtime: 88.93%
     * Memory: 97.64%
     */
    public int heightChecker(int[] heights) {
        int n = heights.length, mismatchNumber = 0;
        int[] sorted = heights.clone();
        Arrays.sort(heights);

        for (int i=0; i<n; ++i) {
            if (sorted[i] != heights[i]) {
                ++mismatchNumber;
            }
        }

        return mismatchNumber;
    }
}
