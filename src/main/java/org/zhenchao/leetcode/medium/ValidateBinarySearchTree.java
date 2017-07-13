package org.zhenchao.leetcode.medium;

import org.zhenchao.leetcode.basic.TreeNode;

/**
 * 98. Validate Binary Search Tree
 *
 * @author zhenchao.wang 2017-07-11 20:57
 * @version 1.0.0
 */
public class ValidateBinarySearchTree {

    /**
     * 采用中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) return false;
        return this.inorderTraversal(root, null);
    }

    private boolean inorderTraversal(TreeNode node, TreeNode pre) {
        if (null != node.left) return this.inorderTraversal(node.left, pre);
        if (null != pre && pre.val > node.val) {
            return false;
        } else {
            pre = node;
        }
        if (null != node.right) return this.inorderTraversal(node.right, pre);
        return true;
    }

}
