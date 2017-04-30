package org.zhenchao.leetcode.hard;

import org.zhenchao.leetcode.basic.ListNode;
import org.zhenchao.leetcode.util.ListNodeUtils;

/**
 * No.25 Reverse Nodes in k-Group
 *
 * @author zhenchao.wang 2017-04-30 16:24
 * @version 1.0.0
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1), tmp = newHead;

        return newHead.next;
    }

    private ListNode reverse2(ListNode pre, ListNode next) {
        ListNode last = pre.next; //where first will be doomed "last"
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode p = left;
        while (p != right) {
            p.next = head.next;
            head.next = p;
            p = left.next;
            left = left.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup rng = new ReverseNodesInKGroup();
        ListNode list = ListNodeUtils.build(1, 2, 3, 4, 5, 6, 7, 8);
        ListNodeUtils.display(rng.reverse2(list, list.next.next));
    }

}
