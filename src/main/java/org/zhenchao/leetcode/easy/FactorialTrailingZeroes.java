package org.zhenchao.leetcode.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * @author Apache_xiaochao 2015-10-3 15:45:55
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int count = 0;
        while (n / 5 > 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

}
