package org.zhenchao.leetcode.medium;


import org.zhenchao.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    List<List<Integer>> llist = new ArrayList<List<Integer>>();

    public void findPath(TreeNode node, int sum, int val, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (val + node.val == sum) {
                this.llist.add(new ArrayList<Integer>(list));
            }
        }
        if (node.left != null) {
            list.add(node.left.val);
            this.findPath(node, sum, val + node.left.val, list);
        }
        if (node.right != null) {
            list.add(node.right.val);
            this.findPath(node, sum, val + node.right.val, list);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.findPath(root, sum, 0, new ArrayList<Integer>());
        return this.llist;
    }

}
