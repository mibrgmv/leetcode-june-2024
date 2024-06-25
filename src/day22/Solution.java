package day22;

import java.util.Arrays;

public class Solution {
    /**
     * day 22
     * 1248. Count Number of Nice Subarrays (Medium)
     * Runtime: 72.90%
     * Complexity: 65.91%
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int currentSubarrays = 0;
        int numberOfSubarrays = 0;
        for (int i = 0; i < n; ++i) {
            nums[i] %= 2;
        }
        for (int i = 0, j = 0; j < n; ++j) {
            if (nums[j] == 1) {
                ++count;
                currentSubarrays = 0;
            }
            while (count == k) {
                ++currentSubarrays;
                count -= nums[i++];
            }
            numberOfSubarrays += currentSubarrays;
        }

        return numberOfSubarrays;
    }
}
