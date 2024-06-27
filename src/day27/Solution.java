package day27;

import java.util.*;

class Solution {
    /**
     * day 27
     * 1791. Find Center of Star Graph (Easy)
     * Runtime: 100.00%
     * Memory: 79.37%
     */
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] e : edges) {
            if (set.contains(e[0])) {
                return e[0];
            }
            if (set.contains(e[1])) {
                return e[1];
            }
            set.add(e[0]);
            set.add(e[1]);
        }
        return -1;
    }
}
