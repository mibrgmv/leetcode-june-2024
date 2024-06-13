package day6;

import java.util.Arrays;

public class Solution {
    /**
     * day 6
     * 846. Hand of Straights (Medium)
     * Runtime: 99.76%
     * Memory: 99.82%
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);

        for (int i = 0; i < n; ++i) {
            if (hand[i] == -1) {
                continue;
            }
            int currentGroupSize = 1, prevGroupMember = hand[i];
            for (int j = i + 1; j < n && currentGroupSize < groupSize; ++j) {
                if (prevGroupMember + 1 == hand[j]) {
                    prevGroupMember = hand[j];
                    hand[j] = -1;
                    ++currentGroupSize;
                }
            }
            if (currentGroupSize != groupSize) {
                return false;
            }
        }
        return true;
    }
}
