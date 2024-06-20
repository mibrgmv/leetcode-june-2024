package day20;

import java.util.Arrays;

public class Solution {
    /**
     * day 20
     * 1552. Magnetic Force Between Two Balls (Medium)
     * Runtime: 79.08%
     * Complexity: 93.35%
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int i = 0;
        int j = position[position.length - 1] - position[0];
        int maxDistance = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (isPossible(position, m, mid)) {
                i = mid + 1;
                maxDistance = mid;
            } else {
                j = mid - 1;
            }
        }

        return maxDistance;
    }

    private boolean isPossible(int[] position, int m, int x) {
        int lastPos = 0;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - position[lastPos] >= x) {
                lastPos = i;
                --m;
                if (m <= 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
