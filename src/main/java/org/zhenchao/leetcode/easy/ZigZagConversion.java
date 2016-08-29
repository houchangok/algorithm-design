package org.zhenchao.leetcode.easy;

/**
 * No.6
 *
 * @author zhenchao.Wang  2016-8-29 22:13:06
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        String[] res = new String[numRows];

        int i = 0, j, gap = numRows - 2;
        while (i < s.length()) {
            for (j = 0; i < s.length() && j < numRows; ++j) {
                res[j] += s.charAt(i++);
            }
            for (j = gap; i < s.length() && j > 0; --j) {
                res[j] += s.charAt(i++);
            }
        }
        StringBuilder str = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            str.append(res[i]);
        }
        return str.toString();

    }

    public static void main(String[] args) {

        ZigZagConversion zzc = new ZigZagConversion();

        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(zzc.convert(s, numRows));


    }

}
