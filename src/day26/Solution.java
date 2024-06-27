package day26;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * day 26
     * 1382. Balance a Binary Search Tree (Medium)
     * Runtime:
     * Memory:
     */
    List<Integer> inOrderTraversal = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return createBalancedBST(0, inOrderTraversal.size() - 1);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrderTraversal.add(node.val);
        inOrder(node.right);
    }

    private TreeNode createBalancedBST(int i, int j) {
        if (j - i <= 0) {
            return null;
        }
        int k = i + (j - i) / 2;
        TreeNode node = new TreeNode(inOrderTraversal.get(k));
        node.left = createBalancedBST(i, k - 1);
        node.right = createBalancedBST(k + 1, j);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
