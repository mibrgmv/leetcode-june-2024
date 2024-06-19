package day19;

public class Solution {
    /**
     * day 19
     * 1482. Minimum Number of Days to Make m Bouquets (Medium)
     * Runtime: 98.48%
     * Memory: 99.28%
     */
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int minDays = -1;
        int l = 1;
        int r = 1;
        for (int b : bloomDay) {
            r = Math.max(r, b);
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int currentBouquetSize = 0;
            int numberOfBouquets = 0;
            for (int i = 0; i < n; ++i) {
                while (i < n && bloomDay[i] <= mid) {
                    ++currentBouquetSize;
                    ++i;
                }
                numberOfBouquets += currentBouquetSize / k;
                currentBouquetSize = 0;
            }

            if (numberOfBouquets < m) {
                l = mid + 1;
            } else if (numberOfBouquets >= m) {
                r = mid - 1;
                minDays = mid;
            }
        }

        return minDays;
    }
}
