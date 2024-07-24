package day25;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * day 25
     * 1038. Binary Search Tree to Greater Sum Tree
     * Runtime: 100.00%
     * Memory: 98.65%
     */
    private List<TreeNode> order = new ArrayList<>();

    public TreeNode bstToGst(TreeNode root) {
        inOrderReversed(root);
        int greaterSum = 0;
        for (TreeNode tr : order) {
            int val = tr.val;
            tr.val += greaterSum;
            greaterSum += val;
        }

        return root;
    }

    private void inOrderReversed(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderReversed(root.right);
        order.add(root);
        inOrderReversed(root.left);
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
