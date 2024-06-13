package day4;

import java.util.Arrays;

public class Solution {
    /**
     * day 4
     * 409. Longest Palindrome (Easy)
     * Runtime: 86.33%
     * Memory: 81.81%
     */
    public int longestPalindrome(String s) {
        boolean[] isLetterSingular = new boolean[58];
        Arrays.fill(isLetterSingular, false);
        int singularLetters = 0;
        for (char c : s.toCharArray()) {
            if (!isLetterSingular[c - 'A']) {
                ++singularLetters;
                isLetterSingular[c - 'A'] = true;
            } else {
                --singularLetters;
                isLetterSingular[c - 'A'] = false;
            }
        }
        if (singularLetters < 2) {
            return s.length();
        } else {
            return s.length() - singularLetters + 1;
        }
    }
}
