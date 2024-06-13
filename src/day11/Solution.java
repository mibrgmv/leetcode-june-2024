package day11;

import java.util.Arrays;

public class Solution {
    /**
     * day 11
     * 1122. Relative Sort Array (Easy)
     * Runtime: 100.00%
     * Memory: 84.05%
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length, m = Arrays.stream(arr1).max().getAsInt() + 1,  j = 0;
        int[] frequencies = new int[m], ans = new int[n];

        for (int x : arr1) {
            frequencies[x]++;
        }

        for (int i=0; i<arr2.length; ++i) {
            while ((frequencies[arr2[i]])-- > 0) {
                ans[j++] = arr2[i];
            }
        }

        for (int i=0; i<m; ++i) {
            while (frequencies[i]-- > 0) {
                ans[j++] = i;
            }
        }

        return ans;
    }
}
