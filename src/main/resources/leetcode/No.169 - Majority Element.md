### Majority Element

> No.169, easy

Given an array of size n, find the majority element. The majority element is the element that appears more than `⌊ n/2 ⌋` times.

You may assume that the array is non-empty and the majority element always exist in the array.

#### 分析

#### 实现

```java
/**
 * 解法一：直接对数组进行排序，然后选择最中间的数字
 *
 * @param nums
 * @return
 */
public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
}

/**
 * 解法二：投票法
 *
 * @param nums
 * @return
 */
public int majorityElement2(int[] nums) {
    int count = 0, result = nums[0];
    for (int i = 0; i < nums.length; i++) {
        if (count == 0) {
            result = nums[i];
            count++;
        } else if (result == nums[i]) {
            count++;
        } else {
            count--;
        }
    }
    return result;
}
```
