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
        ListNode newHead = head, p = head;
        ListNode left = head, right = null;
        int n = 1;
        while (p != null) {
            if(n % k == 0) {
                right = head;
                this.reverse(left, right);
            }
            head = head.next;
            n++;
        }
        return newHead;
    }

    public ListNode reverse(ListNode left, ListNode right) {
        if (left == null || left.next == null) {
            return left;
        }
        ListNode p = left.next;
        ListNode root = left;
        while (p != right) {
            //删除p结点
            root.next = p.next;
            // 将p结点插入到头结点后面
            ListNode q = p;
            p = p.next;
            q.next = left;
            left = q;
        }
        return left;
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

    public static void main(String[] args) {
        ReverseNodesInKGroup rng = new ReverseNodesInKGroup();
        ListNode list = ListNodeUtils.build(1, 2, 3, 4, 5, 6, 7, 8);
        ListNodeUtils.display(rng.reverse(list, list.next.next.next));
    }

}
