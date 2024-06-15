package day15;

import java.util.*;

class Solution {
    /**
     * day 15
     * 502. IPO (Hard)
     * Runtime: 86.89%
     * Memory: 61.56%
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Pair> projects = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            projects.add(new Pair(capital[i], profits[i]));
        }

        projects.sort((a, b) -> a.first - b.first);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < k; ++i) {
            while (j < n && projects.get(j).first <= w) {
                maxHeap.add(projects.get(j++).second);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }

        return w;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
