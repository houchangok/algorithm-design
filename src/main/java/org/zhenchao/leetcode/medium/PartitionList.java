package org.zhenchao.leetcode.medium;

import org.zhenchao.leetcode.basic.ListNode;
import org.zhenchao.leetcode.util.ListNodeUtils;

/**
 * No.86 Partition List
 *
 * @author zhenchao.wang 2017-06-20 17:39
 * @version 1.0.0
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode g = head, op = new ListNode(-1);
        while (null != g && g.val < x) {
            op = g;
            g = g.next;
        }
        // System.out.println(g.val);
        if (null == g) return head;
        ListNode idx = g.next, pre = g;
        while (null != idx) {
            if (idx.val < x) {
                pre.next = idx.next;
                ListNode tmp = idx;
                idx = idx.next;
                tmp.next = g;
                op.next = tmp;
                op = op.next;
            } else {
                pre = pre.next;
                idx = idx.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode head = ListNodeUtils.build(1, 4, 3, 2, 5, 2);
        ListNodeUtils.display(pl.partition(head, 3));
    }

}
