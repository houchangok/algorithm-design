package org.zhenchao.leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author Apache_xiaochao 2015-9-28 21:28:35
 */
public class RemoveElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        RemoveElement re = new RemoveElement();
        int len = re.removeElement(nums, val);
        System.out.println(len);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));
    }

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            if (nums[left] == val && right > left) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right--;
            }
            left++;
        }

        return right + 1;
    }

}
