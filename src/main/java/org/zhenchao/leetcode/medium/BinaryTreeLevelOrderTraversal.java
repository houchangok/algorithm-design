package org.zhenchao.leetcode.medium;

import org.zhenchao.leetcode.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * @author zhenchao.wang 2017-07-16 16:22
 * @version 1.0.0
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == root) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 1, n = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (count == Math.pow(2, n)) {
                result.add(new ArrayList<Integer>(list));
                list = new ArrayList<Integer>();
                count = 0;
                n++;
            }
            if (null != node.left) queue.add(node.left);
            if (null != node.right) queue.add(node.right);
            count++;
        }
        if (!list.isEmpty()) result.add(new ArrayList<Integer>(list));
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        List<List<Integer>> list = btlot.levelOrder(root);
        for (final List<Integer> l : list) {
            System.out.println(l);
        }
    }

}
