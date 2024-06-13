package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * day 5
     * 1002. Find Common Characters (Easy)
     * Runtime: 88.56%
     * Memory: 85.48%
     */
    public List<String> commonChars(String[] words) {
        List<String> commonCharacters = new ArrayList<>();
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] concreteFreq = new int[26];
            for (char c : word.toCharArray()) {
                ++concreteFreq[c - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                freq[i] = Math.min(freq[i], concreteFreq[i]);
            }
        }

        for (int i = 0; i < 26; ++i) {
            while (freq[i]-- > 0) {
                commonCharacters.add("" + (char) (i + 'a'));
            }
        }
        return commonCharacters;
    }
}
