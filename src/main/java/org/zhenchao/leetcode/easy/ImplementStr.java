package org.zhenchao.leetcode.easy;


/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * @author Apache_xiaochao 2015-9-28 22:09:58
 */
public class ImplementStr {

    public static void main(String[] args) {
        ImplementStr is = new ImplementStr();
        //System.out.println(Arrays.toString(is.nextArr("issipi")));
        System.out.println(is.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        //System.out.println(is.strStr("mississippi", "issipi"));
    }

    private int[] nextArr(String needle) {

        int[] next = new int[needle.length()];
        next[0] = -1; // 首字母的next值始终为-1
        int k = -1;
        for (int i = 1; i < needle.length(); ) {
            if (k == -1 || needle.charAt(i - 1) == needle.charAt(k)) {
                k++;
                next[i] = k;
                i++;
            } else {
                k = next[k];
            }

        }

        return next;

    }

    /**
     * 判断needle是不是haystack的子串
     *
     * @param haystack
     * @param needle
     *
     * @return
     */
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        // 计算needle的next数组
        int[] next = this.nextArr(needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return i - j + 1;
                }
            } else if (j != 0) {
                j = next[j];
            }
        }
        return -1;

    }

}
