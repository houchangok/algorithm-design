package org.zhenchao.leetcode.easy;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * @author Apache_xiaochao 2015-9-27 17:54:47
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 用两个指针，当出现不重复的数的时候两个指针分别右移一个单位，同时两个指针所指的元素交换，否则仅第二个指针右移一个单位
     *
     * @param nums
     *
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int firstIndex = 0;
        int secondIndex = 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                secondIndex++;
            } else {
                firstIndex++;
                secondIndex++;
                curr = nums[i];
                int tmp = nums[firstIndex];
                nums[firstIndex] = nums[secondIndex];
                nums[secondIndex] = tmp;
            }
        }

        return firstIndex + 1;

    }

}
