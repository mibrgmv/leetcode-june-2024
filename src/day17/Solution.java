package day17;

class Solution {
    /**
     * day 17
     * 633. Sum of Square Numbers (Medium)
     * Runtime: 97.79%
     * Memory: 65.09%
     */
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            long val = a * a + b * b;
            if (val < c) {
                ++a;
            } else if (val > c) {
                --b;
            } else {
                return true;
            }
        }

        return false;
    }
}
