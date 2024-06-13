package day9;

public class Solution {
    /**
     * day 9
     * 942. Subarray Sums Divisible by K (Medium)
     * Runtime: 98.47%
     * Memory: 94.75%
     */
    public int subarraysDivByK(int[] nums, int k) {
        int mod, subarrayCount = 0, remainderSum = 0;
        int[] remainders = new int[k];
        remainders[0] = 1;

        for (int x : nums) {
            remainderSum += x;
            mod = (remainderSum % k + k) % k;
            subarrayCount += remainders[mod];
            ++remainders[mod];
        }

        return subarrayCount;
    }
}
