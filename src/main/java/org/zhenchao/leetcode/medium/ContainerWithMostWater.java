package org.zhenchao.leetcode.medium;

/**
 * Container With Most Water
 *
 * @author Apache_xiaochao 2015-9-26 17:36:09
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;  // 左指针
        int right = height.length - 1;  // 右指针

        int max = Integer.MIN_VALUE;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                max = area;
            }
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return max;

    }

}
