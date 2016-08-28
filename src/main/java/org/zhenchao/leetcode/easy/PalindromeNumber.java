package org.zhenchao.leetcode.easy;

/**
 * Determine whether an integer is a palindrome.<br/>
 * Do this without extra space.
 *
 * @author Apache_xiaochao 2015-9-26 11:46:26
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(10022001));
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        if (x >= 0 && x <= 9) {
            return true;
        }

        // 获取一个用于取模的数
        int base = 10;
        while (x / base >= 10) {
            base *= 10;
        }

        while (x > 0) {
            int left = x / base;  // 获取头数
            int right = x % 10;  // 获取尾数
            if (left != right) {
                return false;
            }
            x -= left * base;  // 去掉已经检测过头数
            x /= 10; // 去掉已经检测过的尾数
            base /= 100;  // 因为每次去掉首尾两个数，所以这里需要模100

        }
        return true;
    }
}
