### Two Sum

> - No.1, easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

```text
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

#### 分析

该题的考点在于给定一个数 target 和一个数组 nums，然后从数组 nums 中找到两个数之和等于 target，返回这两个数的下标（返回一组即可）。

- 思路一

将数组中的数散列存储到一个map中（因为数组中可能存在多个相同的值，所以建议使用一键多值map），然后从头开始遍历数组，假设当前数值为x，那么就查询map中是否存在（target - x）,如果存在则返回这两个数的下标，否则继续向前遍历。空间复杂度为O(n)，时间复杂度为O(n)。

- 思路二

先将数组按从小到大排序，然后用两个指针，一个首指针和一个尾指针，然后从两边向中间遍历。因为排序后需要记录原先对应的下标，所以空间复杂度为O(n)，时间复杂度MAX(O(n), O(排序))。

#### 实现

- 公共接口

```java
class Node implements Comparable<Node> {

        int id;
        int val;

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            return this.val - other.val;
        }

    }
```

- 思路一

```java
public int[] twoSum(int[] nums, int target) {

    int[] results = new int[2];

    // Map映射
    Map<Integer, List<Node>> nodeMap = new HashMap<Integer, List<Node>>();
    for (int i = 0; i < nums.length; i++) {
        List<Node> nodes = nodeMap.get(Integer.valueOf(nums[i]));
        if (null == nodes) {
            nodes = new ArrayList<Node>();
        }
        nodes.add(new Node(i, nums[i]));
        nodeMap.put(Integer.valueOf(nums[i]), nodes);
    }

    // 遍历寻找
    for (int i = 0; i < nums.length; i++) {
        List<Node> nodes = nodeMap.get(Integer.valueOf(target - nums[i]));
        if (null == nodes) {
            continue;
        }
        if (nodes.size() == 1) {
            Node node = nodes.get(0);
            if (node.val == nums[i]) {
                continue;
            }
            results[0] = i;
            results[1] = node.id;
        } else {
            results[0] = i;
            results[1] = nodes.get(1).id;
        }
        return results;
    }

    return results;
}
```

- 思路二（基于排序）

```java
public int[] twoSum(int[] nums, int target) {

    int[] result = new int[2];
    Node[] nodes = new Node[nums.length];

    // 重新构造数组
    for (int i = 0; i < nums.length; i++) {
        nodes[i] = new Node(i, nums[i]);
    }

    // 从小到大排序
    Arrays.sort(nodes);

    // 查找
    int left = 0, right = nums.length - 1;
    int currentVal;
    while (left < right) {
        currentVal = nodes[left].val + nodes[right].val;
        if (currentVal == target) {
            result[0] = nodes[left].id;
            result[1] = nodes[right].id;
            return result;
        } else if (currentVal < target) {
            left++;
        } else {
            right--;
        }
    }

    return result;
}
```

### Two Sum II - Input array is sorted

> No.167, easy

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

> - Input: numbers={2, 7, 11, 15}, target=9
> - Output: index1=1, index2=2

#### 分析

这道题是 Two Sum 的简化版，输入的数组已经是有序的，所以不需要再进行排序，直接用两个指针由两端向中间遍历即可。

#### 实现

```java
public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int left = 0, right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum < target) {
            left++;
        } else if (sum > target) {
            right--;
        } else {
            result[0] = left + 1;
            result[1] = right + 1;
            break;
        }
    }
    return result;
}
```

### Two Sum III - Data structure design

> No.170, easy

未解锁

### Two Sum IV - Input is a BST

> No.653, easy

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

```text
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```

Example 2:

```text
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

#### 分析

这道题虽然输入的是一个 BST，但是核心解题思路还是不变的，我可以基于中序遍历获取 BST 对应的有序集合，然后就关联到 Two Sum 的基本解法。

#### 实现

```java
public boolean findTarget(TreeNode root, int k) {
    if (null == root) return false;
    List<Integer> list = new ArrayList<Integer>();
    this.inorderTraversal(root, list);
    int i = 0, j = list.size() - 1;
    while (i < j) {
        int sum = list.get(i) + list.get(j);
        if (sum == k) {
            return true;
        } else if (sum < k) {
            i++;
        } else {
            j--;
        }
    }
    return false;
}

/**
 * 中序遍历获取有序集合
 *
 * @param node
 * @param list
 */
private void inorderTraversal(TreeNode node, List<Integer> list) {
    if (null != node.left) {
        this.inorderTraversal(node.left, list);
    }
    list.add(node.val);
    if (null != node.right) {
        this.inorderTraversal(node.right, list);
    }
}
```
