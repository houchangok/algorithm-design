### 题目

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

### 分析

比较经典的一道题，题目意思是说，n 个数以一个单位的间距在一条线上均匀分布，假设每个数都代表一个高度，要求从中找出两个数，使这两个数与底板构成的封闭区域能够容纳最多的水，即两个数中较小者与两个数间距的乘积最大。

这题目可以沿用之前解最长回文子串的动态规划的思想，不过放在这里有点杀鸡用牛刀的意思，并且需要更多的存储空间。较好的一种解法：给定两个指针，一开始分别指向数组的首和尾，然后计算当前表示的面积，并用一个值记录最大的面积（最后要求返回最大面积值），然后比较指针所指向的两个数，较小的一端的指针前进一位，知道两个指针相遇为止。

### 实现

```java
/**
 * 用两个指针从两边向中间移动，每次比较当前两个指针对应的值，小的一端往前进一格，同时计算当前的面积，保存最大值
 *
 * @param height
 * @return
 */
public int maxArea(int[] height) {
    int left = 0;  // 左指针
    int right = height.length - 1;  // 右指针

    int max = Integer.MIN_VALUE;
    while (left < right) {
        // 计算面积
        int area = (right - left) * Math.min(height[left], height[right]);
        if (area > max) {
            // 缓存最大面积
            max = area;
        }
        // 哪边高度小，哪边移动
        if (height[left] <= height[right]) {
            ++left;
        } else {
            --right;
        }
    }

    return max;
}
```