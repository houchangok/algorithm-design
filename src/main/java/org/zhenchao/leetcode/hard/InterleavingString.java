package org.zhenchao.leetcode.hard;

/**
 * 97. Interleaving String
 *
 * @author zhenchao.wang 2017-07-10 22:00
 * @version 1.0.0
 */
public class InterleavingString {

    /**
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];
        flag[0][0] = true;
        for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            flag[i][0] = true;
        }
        for (int i = 1; i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            flag[0][i] = true;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c = s3.charAt(i + j - 1);
                if (c == s1.charAt(i - 1) && flag[i - 1][j]) {
                    flag[i][j] = true;
                } else if (c == s2.charAt(j - 1) && flag[i][j - 1]) {
                    flag[i][j] = true;
                }
            }
        }
        return flag[s1.length()][s2.length()];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++)
            dp[i][0] = true;

        for (int i = 1; i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1); i++)
            dp[0][i] = true;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c = s3.charAt(i + j - 1);
                if (c == s1.charAt(i - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }

                if (c == s2.charAt(j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        String s1 = "aabcc", s2 = "abbca", s3 = "aadbbcbcac";
        System.out.println(is.isInterleave2(s1, s2, s3));
    }

}
