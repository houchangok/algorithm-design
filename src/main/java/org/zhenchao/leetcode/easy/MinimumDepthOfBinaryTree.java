package org.zhenchao.leetcode.easy;


import org.zhenchao.leetcode.common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author Apache_xiaochao 2015-10-2 16:28:52
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = root.left != null ? this.minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? this.minDepth(root.right) : Integer.MAX_VALUE;
        return Math.min(leftDepth, rightDepth) + 1;
    }

}
