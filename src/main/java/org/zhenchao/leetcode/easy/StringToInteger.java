package org.zhenchao.leetcode.easy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement atoi to convert a string to an integer.
 * 题目不难，坑比较多
 *
 * @author Apache_xiaochao 2015-10-9 21:34:16
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.myAtoi("18446744073709551617"));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        char first = str.charAt(0);
        int i = 0;
        if (first == '+' || first == '-') {
            i = 1;
        } else if (first >= '0' && first <= '9') {
            i = 0;
        } else {
            return 0;
        }
        List<Character> list = new ArrayList<Character>();
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            list.add(str.charAt(i));
            i++;
        }
        if (list.size() == 0) {
            return 0;
        }
        BigDecimal num = BigDecimal.ZERO;
        BigDecimal base = BigDecimal.ONE;
        for (int j = list.size() - 1; j >= 0; j--) {
            num = num.add(base.multiply(new BigDecimal(list.get(j) - 48)));
            base = base.multiply(new BigDecimal(10));
        }
        System.out.println(num);
        if (first == '-') {
            num = num.negate();
            return num.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1 ? Integer.MIN_VALUE : num.intValue();
        } else {
            return num.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1 ? Integer.MAX_VALUE : num.intValue();
        }
    }

}
