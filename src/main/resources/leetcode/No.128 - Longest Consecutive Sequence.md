### Longest Consecutive Sequence

> No.128, hard

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,  
Given [100, 4, 200, 1, 3, 2],  
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

#### 分析

#### 实现

```java
/**
 * 基于 HashSet
 *
 * @param nums
 * @return
 */
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    for (final int num : nums) {
        set.add(num);
    }
    int max = 0;
    for (final int num : nums) {
        max = Math.max(max, this.downTraversal(num, set) + this.upTraversal(num, set));
    }
    return max;
}

/**
 * 向下遍历
 *
 * @param num
 * @param set
 * @return
 */
private int downTraversal(int num, Set<Integer> set) {
    int len = 0;
    for (int i = num; ; i--) {
        if (set.contains(i)) {
            len++;
            set.remove(i);
        } else {
            return len;
        }
    }
}

/**
 * 向上遍历
 *
 * @param num
 * @param set
 * @return
 */
private int upTraversal(int num, Set<Integer> set) {
    int len = 0;
    for (int i = num + 1; ; i++) {
        if (set.contains(i)) {
            len++;
            set.remove(i);
        } else {
            return len;
        }
    }
}
```
