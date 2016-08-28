package org.zhenchao.leetcode.easy;

import java.util.Scanner;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * @author Apache_xiaochao 2015-9-26 19:16:11
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        System.out.println("前缀：" + lcp.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        /*
         * 基本思想也还是当前前缀与每个字符串进行对比的过程
         * 只是每次只需要对比前缀长度个字符即可，这样会极大的减少计算量
         */
        String prefix = strs[0];
        int minLen = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            minLen = Math.min(minLen, str.length());
            int tmpLen = 0;
            for (int j = 0; j < minLen; j++) {
                if (prefix.charAt(j) == str.charAt(j)) {
                    tmpLen++;
                } else {
                    break;
                }
            }
            if (tmpLen == 0) {
                return "";
            }
            minLen = tmpLen;
            prefix = prefix.substring(0, tmpLen);
        }
        return prefix;

    }

}
