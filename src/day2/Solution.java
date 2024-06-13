package day2;

public class Solution {
    /**
     * day 2
     * 344. Reverse String (Easy)
     * Runtime: 100.00%
     * Memory: 84.24%
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
