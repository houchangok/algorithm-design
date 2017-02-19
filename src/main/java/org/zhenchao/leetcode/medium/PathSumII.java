package org.zhenchao.leetcode.medium;


import org.zhenchao.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    List<List<Integer>> llist = new ArrayList<List<Integer>>();

    public void findPath(TreeNode node, int sum, int val, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (val + node.value == sum) {
                this.llist.add(new ArrayList<Integer>(list));
            }
        }
        if (node.left != null) {
            list.add(node.left.value);
            this.findPath(node, sum, val + node.left.value, list);
        }
        if (node.right != null) {
            list.add(node.right.value);
            this.findPath(node, sum, val + node.right.value, list);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.findPath(root, sum, 0, new ArrayList<Integer>());
        return this.llist;
    }

}
