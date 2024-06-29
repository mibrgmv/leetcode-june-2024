package day28;

import java.util.Arrays;

public class Solution {
    /**
     * day 28
     * 2285. Maximum Total Importance of Roads (Medium)
     * Runtime: 87.61%
     * Memory: 69.74%
     */
    public long maximumImportance(int n, int[][] roads) {
        int[] importance = new int[n];
        long maximumImportance = 0;
        for (int[] r : roads) {
            ++importance[r[0]];
            ++importance[r[1]];
        }
        Arrays.sort(importance);
        for (int i = 1; i <= n; ++i) {
            maximumImportance += (long) importance[i - 1] * i;
        }
        return maximumImportance;
    }
}
