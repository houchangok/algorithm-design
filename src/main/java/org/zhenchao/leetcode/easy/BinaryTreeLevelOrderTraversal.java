package org.zhenchao.leetcode.easy;

import org.zhenchao.leetcode.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @author Apache_xiaochao 2015-10-2 15:37:48
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 将一棵二叉树分层存储
     *
     * @param root
     *
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        if (root == null) {
            return llist;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        queue.offer(root);
        level.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer lv = level.poll();
            List<Integer> list = null;

            if (lv > llist.size() - 1) {
                list = new ArrayList<Integer>();
                list.add(node.val);
                llist.add(list);
            } else {
                list = llist.get(lv);
                list.add(node.val);
                llist.set(lv, list);
            }

            if (node.left != null) {
                queue.offer(node.left);
                level.offer(lv + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(lv + 1);
            }
        }

        return llist;
    }

}
