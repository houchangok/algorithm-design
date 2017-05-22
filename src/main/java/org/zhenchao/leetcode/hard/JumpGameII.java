package org.zhenchao.leetcode.hard;

/**
 * @author zhenchao.wang 2017-05-22 17:41
 * @version 1.0.0
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        int max = 0;
        int[] dis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            dis[i] = Math.min(max, nums.length - 1);
        }
        if (dis[nums.length - 1] != nums.length - 1) {
            return 0;
        }
        // System.out.println(Arrays.toString(dis));
        int count = 0;
        int i = 0;
        for (; i < dis.length - 1 && dis[i] != dis.length - 1; ) {
            i = dis[i];
            count++;
        }
        if (i < dis.length) count++;
        return count;
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        int[] nums = {2, 1, 1, 3, 4};
        // int[] nums = {3, 2, 1, 0, 4};
        // int[] nums = {2, 1, 1, 3, 4};
        // int[] nums = {2, 0, 0};
        // int[] nums = {1};
        // int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};

        System.out.println(jg.jump(nums));
    }

}
