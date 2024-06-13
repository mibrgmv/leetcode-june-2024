package day8;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * day 8
     * 523. Continuous Subarray Sum (Medium)
     * Runtime: 97.48%
     * Memory: 96.35%
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i=1; i<n+1; ++i) {
            dp[i] = dp[i-1] + nums[i-1];
        }

        Set<Integer> s = new HashSet<>();
        for (int i=2; i<n+1; ++i) {
            s.add(dp[i-2] % k);
            if (s.contains(dp[i] % k)) {
                return true;
            }
        }
        return false;
    }
}
