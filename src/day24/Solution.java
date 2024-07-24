package day24;

public class Solution {
    /**
     * day 24
     * 995. Minimum Number of K Consecutive Bit Flips (Hard)
     * Runtime: 99.93%
     * Memory: 98.30%
     */
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int currentFlips = 0;
        int minKBitFlips = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] == 2) {
                --currentFlips;
            }
            if (currentFlips % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                nums[i] = 2;
                ++currentFlips;
                ++minKBitFlips;
            }
        }

        return minKBitFlips;
    }
}
