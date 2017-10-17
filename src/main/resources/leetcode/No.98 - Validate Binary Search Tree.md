### 题目

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.


Example 1:

```
    2
   / \
  1   3
```

Binary tree [2,1,3], return true.

Example 2:

```
    1
   / \
  2   3
```

Binary tree [1,2,3], return false.

### 分析

采用中序遍历，因为如果满足二叉搜索树定义，则中序遍历结果是一个递增数列，这道题采用非递归中序遍历实现起来会更加简单。

### 实现

```java
/**
 * 采用非递归中序遍历
 *
 * @param root
 * @return
 */
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode pre = null;
    while (null != root || !stack.isEmpty()) {
        while (null != root) {
            stack.add(root);
            root = root.left;
        }
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != pre && pre.val >= node.val) return false;
            pre = node;
            root = node.right;
        }
    }
    return true;
}
```