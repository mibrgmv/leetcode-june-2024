package day1;

public class Solution {
    /**
     * day 1
     * 3110. Score of a String (Easy)
     * Runtime: 99.52%
     * Memory: 71.28%
     */
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); ++i) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return score;
    }
}
