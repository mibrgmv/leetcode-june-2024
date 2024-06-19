package day12;

public class Solution {
    /**
     * day 12
     * 75. Sort Colors (Medium)
     * Runtime: 100.00%
     * Memory: 77.63%
     */
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int x : nums) {
            ++counts[x];
        }
        for (int i = 0, j = 0; i < 3; ++i) {
            while (counts[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
}
