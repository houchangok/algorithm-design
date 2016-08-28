package org.zhenchao.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']'<br>
 * determine if the input string is valid.
 *
 * @author Apache_xiaochao 2015-9-27 16:46:52
 */
public class ValidParentheses {

    private Set<Character> left  = new HashSet<Character>() {
        {
            this.add('(');
            this.add('{');
            this.add('[');
        }
    };
    private Set<Character> right = new HashSet<Character>() {
        {
            this.add(')');
            this.add('}');
            this.add(']');
        }
    };

    public boolean isValid(String s) {
        boolean valid = false;
        if (s == null) {
            return valid;
        }
        s = s.replaceAll("\\s+", "");
        if ("".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.left.contains(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char r = stack.pop();
                if (c == ')') {
                    if (r != '(') {
                        return false;
                    }
                } else if (c == '}') {
                    if (r != '{') {
                        return false;
                    }
                } else if (c == ']') {
                    if (r != '[') {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            valid = true;
        }
        return valid;
    }

}
