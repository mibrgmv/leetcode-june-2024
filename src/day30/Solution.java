package day30;

public class Solution {
    /**
     * day 30
     * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable (Hard)
     * Runtime: 86.86%
     * Complexity: 56.92%
     */
    public static int MaxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);

        int edgesRequired = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                edgesRequired += (alice.unionSets(edge[1] - 1, edge[2] - 1) | bob.unionSets(edge[1] - 1, edge[2] - 1));
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                edgesRequired += alice.unionSets(edge[1] - 1, edge[2] - 1);
            } else if (edge[0] == 2) {
                edgesRequired += bob.unionSets(edge[1] - 1, edge[2] - 1);
            }
        }

        return (alice.isConnected() && bob.isConnected()) ? edges.length - edgesRequired : -1;
    }

    static class DisjointSet {
        int components;
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            components = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findSet(int v) {
            if (v == parent[v]) {
                return v;
            }
            return parent[v] = findSet(parent[v]);
        }

        int unionSets(int a, int b) {
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                parent[b] = a;
                if (rank[a] == rank[b]) {
                    ++rank[a];
                }
                --components;
                return 1;
            }
            return 0;
        }

        boolean isConnected() {
            return components == 1;
        }
    }
}