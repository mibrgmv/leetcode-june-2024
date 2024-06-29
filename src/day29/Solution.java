package day29;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * day 29
     * 2192. All Ancestors of a Node in a Directed Acyclic Graph (Medium)
     * Runtime: 83.91%
     * Memory: 50.86%
     */
    List<List<Integer>> ancestors = new ArrayList<>();

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
            ancestors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj[edge[1]].add(edge[0]);
        }
        for (int v = 0; v < n; ++v) {
            dfs(adj, v, v, new boolean[n]);
        }

        ancestors.forEach(a -> a.sort(Integer::compareTo));
        return ancestors;
    }

    private void dfs(List<Integer>[] adj, int u, int parent, boolean[] visited) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                ancestors.get(parent).add(v);
                dfs(adj, v, parent, visited);
            }
        }
    }
}
