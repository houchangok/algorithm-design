package org.zhenchao.algorithm.leetcode.util;

/**
 * @author zhenchao.wang 2017-04-25 21:32
 * @version 1.0.0
 */
public class ArrayUtils {

    public static void display(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print((array[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }
}
