### 题目

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

```text
For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

### 分析

同 Three Sum 解题思想。

### 实现

```java
/**
 * @param nums
 * @param target
 * @return
 */
public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closest = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < nums.length - 2; i++) {
        // 去重
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int tSum = nums[left] + nums[right] + nums[i];
            int tClosest = Math.abs(target - tSum);
            if (tSum == target) {
                // 找到相等的，直接返回
                return tSum;
            } else if (tSum > target) {
                right--;
            } else {
                left++;
            }
            if (tClosest < closest) {
                sum = tSum;
                closest = tClosest;
            }
        }
    }
    return sum;
}
```