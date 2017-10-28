### Flatten Binary Tree to Linked List

> No.114, medium

Given a binary tree, flatten it to a linked list in-place.

For example, Given

```
         1
        / \
       2   5
      / \   \
     3   4   6
```

The flattened tree should look like:

```
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
```

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

#### 分析

#### 实现

```java
/**
 * 非递归先序遍历
 *
 * @param root
 */
public void flatten(TreeNode root) {
    if (null == root) return;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    TreeNode index = null;
    while (!stack.isEmpty()) {
        TreeNode pop = stack.pop();
        if (null != pop.right) stack.push(pop.right);
        if (null != pop.left) stack.push(pop.left);
        pop.left = null; // 注意：需要砍掉这些节点的左分支
        if (pop == root) {
            index = pop;
            continue;
        }
        index.right = pop;
        index = index.right;
    }
}
```
