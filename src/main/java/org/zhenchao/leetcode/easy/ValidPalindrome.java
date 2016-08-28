package org.zhenchao.leetcode.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * @author Apache_xiaochao 2015-10-3 13:52:43
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("ab2a"));
        ;
    }

    public boolean isPalindrome(String s) {

        if (s == null) {
            return false;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char left = s.charAt(i);
            if ((left >= 'a' && left <= 'z')
                    || (left >= 'A' && left <= 'Z')
                    || (left >= '0' && left <= '9')) {

            } else {
                ++i;
                continue;
            }
            char right = s.charAt(j);
            if ((right >= 'a' && right <= 'z')
                    || (right >= 'A' && right <= 'Z')
                    || (right >= '0' && right <= '9')) {

            } else {
                --j;
                continue;
            }

            int diff = Math.abs(left - right);
            if (diff == 0 || diff == 32) {
                ++i;
                --j;
            } else {
                return false;
            }

        }
        return true;

    }
}
