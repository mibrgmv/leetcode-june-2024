package day16;

public class Solution {
    /**
     * day 16
     * 330. Patching Array (Hard)
     * Runtime: 100.00%
     * Memory: 90.19%
     */
    public int minPatches(int[] nums, int n) {
        int numOfPatches = 0;
        long elem = 1;

        for (int i = 0; elem <= n; ) {
            if (i < nums.length && nums[i] <= elem) {
                elem += nums[i];
                ++i;
            } else {
                elem *= 2;
                ++numOfPatches;
            }
        }

        return numOfPatches;
    }
}
