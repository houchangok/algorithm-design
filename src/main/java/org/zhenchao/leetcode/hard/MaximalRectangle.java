package org.zhenchao.leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * No.85 Maximal Rectangle
 *
 * @author zhenchao.wang 2017-05-20 15:02
 * @version 1.0.0
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        Arrays.fill(height, 0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
        }
        System.out.println(Arrays.toString(height));
        return this.max(height);
    }

    private int max(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] < height[i]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    int j = stack.pop();
                    int k = stack.isEmpty() ? -1 : stack.peek();
                    max = Math.max(max, (i - k - 1) * height[j]);
                }
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (height.length - k - 1) * height[j]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] arr = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(mr.maximalRectangle(arr));
    }

}
