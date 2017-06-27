package org.zhenchao.leetcode.medium;

import org.zhenchao.leetcode.basic.ListNode;

/**
 * 92. Reverse Linked List II
 *
 * @author zhenchao.wang 2017-06-27 20:52
 * @version 1.0.0
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n <= m) return head;
        ListNode pt = new ListNode(-1), nh = pt;
        pt.next = head;
        ListNode before = head, after = head;
        int dis = n - m;
        while (dis-- > 0) before = before.next;
        while (n-- > 0) {
            pt = after;
            after = after.next;
            before = before.next;
        }
        pt.next = before;
        while (after != before) {
            pt = after.next;
            after.next = before.next;
            before.next = after;
            before = before.next;
        }
        return nh.next;
    }

}
