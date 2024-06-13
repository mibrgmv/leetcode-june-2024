package day3;

public class Solution {
    /**
     * day 3
     * 2486. Append Characters to String to Make Subsequence (Medium)
     * Runtime: 91.69%
     * Memory: 72.72%
     */
    public int appendCharacters(String s, String t) {
        int j = 0, n = s.length(), m = t.length();
        for (int i = 0; i < n && j < m; ++i) {
            if (t.charAt(j) == s.charAt(i)) {
                ++j;
            }
        }
        return m - j;
    }
}
