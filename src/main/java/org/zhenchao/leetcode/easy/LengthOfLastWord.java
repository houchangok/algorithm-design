package org.zhenchao.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * @author Apache_xiaochao 2015-10-2 12:13:30
 */
public class LengthOfLastWord {

    /**
     * 从前向后遍历，不推荐
     */
    /*public int lengthOfLastWord(String s) {

        int len = 0;
        if(s == null) {
            return len;
        }
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ') {
                len++;
            } else {
                len = 0;
            }
        }

        return len;

    }*/

    /**
     * 从后往前遍历计数
     *
     * @param s
     *
     * @return
     */
    public int lengthOfLastWord(String s) {

        int len = 0;
        if (s == null) {
            return len;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && len != 0) {
                break;
            } else if (s.charAt(i) != ' ') {
                len++;
            }
        }

        return len;

    }

}
