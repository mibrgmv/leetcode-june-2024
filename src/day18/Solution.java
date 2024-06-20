package day18;

import java.util.Arrays;

public class Solution {
    /**
     * day 18
     * 826. Most Profit Assigning Work (Medium)
     * Runtime: 97.17%
     * Memory: 49.14%
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int maxDifficulty = Arrays.stream(difficulty).max().getAsInt();
        int maxProfit = 0;

        int[] maxProfitArray = new int[maxDifficulty + 1];
        for (int i = 0; i < n; ++i) {
            maxProfitArray[difficulty[i]] = Math.max(maxProfitArray[difficulty[i]], profit[i]);
        }
        for (int i = 1; i <= maxDifficulty; ++i) {
            maxProfitArray[i] = Math.max(maxProfitArray[i], maxProfitArray[i-1]);
        }
        for (int w : worker) {
            maxProfit += (w > maxDifficulty) ? maxProfitArray[maxDifficulty] : maxProfitArray[w];
        }

        return maxProfit;
    }
}
