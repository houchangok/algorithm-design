package org.zhenchao.leetcode.easy;

import org.zhenchao.leetcode.common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author Apache_xiaochao 2015-10-2 16:16:06
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 计算一棵树的最大深度
     *
     * @param root
     *
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = this.maxDepth(root.left);
        int rightDepth = this.maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
