package day14;

import java.util.Arrays;

class Solution {
    /**
     * day 14
     * 945. Minimum Increment to Make Array Unique (Medium)
     * Runtime: 86.56%
     * Memory: 99.67%
     */
    public int minIncrementForUnique(int[] nums) {
        int[] mp = new int[101000];
        for (int x : nums) {
            ++mp[x];
        }
        int minIncrement = 0;
        for (int i = 0; i < mp.length; ++i) {
            if (mp[i] > 1) {
                int diff = mp[i] - 1;
                mp[i + 1] += diff;
                minIncrement += diff;
            }
        }
        return minIncrement;
    }
}
