package org.zhenchao.leetcode.easy;

import org.junit.Assert;

import java.util.Stack;

/**
 * 155. Min Stack
 *
 * @author zhenchao.wang 2017-09-10 11:28
 * @version 1.0.0
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (x <= min.peek()) {
                min.push(x);
            }
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }

}
