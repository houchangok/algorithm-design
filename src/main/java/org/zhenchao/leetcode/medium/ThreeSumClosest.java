package org.zhenchao.leetcode.medium;

import java.util.Arrays;

/**
 * No.16 Three Sum Closest
 *
 * @author zhenchao.wang 2017-04-28 17:54
 * @version 1.0.0
 */
public class ThreeSumClosest {

    private int twoSum(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        boolean flag = false;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
                flag = false;
            } else if (sum > target) {
                right--;
                flag = true;
            } else {
                return target;
            }
        }
        return flag ? nums[left] + nums[right + 1] : nums[left - 1] + nums[right];
    }

    public int threeSumClosest(int[] nums, int target) {
        int basic = nums[0] + nums[1] + nums[2];
        if (nums.length == 3) {
            return basic;
        }
        Arrays.sort(nums);
        int min = Math.abs(target - basic);
        int result = min;
        int pre = nums[0];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == pre) continue;
            int closest = this.twoSum(nums, i + 1, target - nums[i]) + nums[i];
            if (Math.abs(target - closest) < min) {
                min = Math.abs(target - closest);
                result = closest;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        // int[] nums = {-1, 2, 1, -4};
        // int[] nums = {0, 0, 0};
        int[] nums = {1, 1, 1, 1};
        System.out.println(tsc.threeSumClosest(nums, 1));
    }

}
