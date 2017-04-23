package org.zhenchao.leetcode.easy;


import org.zhenchao.leetcode.basic.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * @author Apache_xiaochao 2015-10-2 16:47:53
 */
public class PathSum {

    private boolean calculate(TreeNode root, int sum, int val) {

        if (root == null) {
            return false;
        }
        val += root.value;
        if (root.left == null && root.right == null) {
            if (val == sum) {
                return true;
            }
        }
        return this.calculate(root.left, sum, val) || this.calculate(root.right, sum, val);

    }

    /**
     * 递归
     *
     * @param root
     * @param sum
     *
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return this.calculate(root, sum, 0);
    }

    /**
     * 非递归
     *
     * @param root
     * @param sum
     *
     * @return
     */
    public boolean hasPathSumNonRecursive(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();
        nodes.push(root);
        sums.push(root.value);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            Integer currSum = sums.pop();
            if (node.left == null && node.right == null) {
                if (currSum == sum) {
                    return true;
                }
            }

            if (node.right != null) {
                nodes.push(node.right);
                sums.push(currSum + node.right.value);
            }

            if (node.left != null) {
                nodes.push(node.left);
                sums.push(currSum + node.left.value);
            }

        }

        return false;

    }

}
