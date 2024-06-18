package day18;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfitAssignment(new int[] {13,37,58}, new int[] {4,90,96}, new int[] {34,73,45}));
        System.out.println(new Solution().maxProfitAssignment(new int[] {2,4,6,8,10}, new int[] {10,20,30,40,50}, new int[] {4,5,6,7}));
    }
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
