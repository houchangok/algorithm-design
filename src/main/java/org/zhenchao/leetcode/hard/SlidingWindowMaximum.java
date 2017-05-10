package org.zhenchao.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.239 Sliding Window Maximum
 *
 * @author zhenchao.wang 2017-05-10 17:50
 * @version 1.0.0
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 存放数组下标
        int[] result = new int[nums.length - k];
        int max = nums[0], index = 0;
        for (int i = 1; i < k; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.add(index);
        for (int i = k; i < nums.length; i++) {
            if(deque.isEmpty() || nums[i] < nums[deque.peekFirst()]) {
                // 新的值小于队列中的值
                deque.addLast(i);
            } else {
                // 新的值大于队列中的一部分值
                if(nums[deque.peekLast()] < nums[i]) {
                    // 删除队列中小于当前值的值
                    deque.pollLast();
                }
                deque.addLast(i);
            }
        }

        return result;
    }

}
