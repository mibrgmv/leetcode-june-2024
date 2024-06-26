package day23;

import java.util.*;

public class Solution {
    /**
     * day 23
     * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (Medium)
     * Runtime: 72.15%
     * Complexity: 91.41%
     */
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int maxLength = 0;
        List<Integer> maxDeque = new ArrayList<>();
        List<Integer> minDeque = new ArrayList<>();

        for (int i = 0, j = 0; j < n; ++j) {
            while (!maxDeque.isEmpty() && maxDeque.getLast() < nums[j]) {
                maxDeque.removeLast();
            }
            maxDeque.add(nums[j]);
            while (!minDeque.isEmpty() && minDeque.getLast() > nums[j]) {
                minDeque.removeLast();
            }
            minDeque.add(nums[j]);

            int diff = maxDeque.getFirst() - minDeque.getFirst();
            if (diff > limit) {
                if (maxDeque.getFirst() == nums[i]) {
                    maxDeque.removeFirst();
                }
                if (minDeque.getFirst() == nums[i]) {
                    minDeque.removeFirst();
                }
                ++i;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
