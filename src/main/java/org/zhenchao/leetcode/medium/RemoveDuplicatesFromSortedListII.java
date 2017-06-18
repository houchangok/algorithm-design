package org.zhenchao.leetcode.medium;

import org.zhenchao.leetcode.basic.ListNode;
import org.zhenchao.leetcode.util.ListNodeUtils;

/**
 * No.82 Remove Duplicates from Sorted List II
 *
 * @author zhenchao.wang 2017-06-18 20:52
 * @version 1.0.0
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode op = null, pre = head, idx = head.next;
        int count = 0;
        while (idx != null) {
            // System.out.println("op=" + (null == op ? "NA" : op.val) + "\tpre=" + pre.val + "\tidx=" + idx.val + "\tcount=" + count);
            if (idx.val == pre.val) {
                count++;
            } else {
                if (count > 0) {
                    // 执行删除操作
                    if (null == op) {
                        head = idx;
                    } else {
                        op.next = idx;
                    }
                    count = 0;
                }
                pre = idx;
                op = null == op ? idx : ((null == idx.next || idx.val != idx.next.val) ? op.next : op);
            }
            idx = idx.next;
        }
        if (count > 0 && null != op) op.next = null;
        return null == op ? null : head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII rdsl = new RemoveDuplicatesFromSortedListII();
        ListNode head = ListNodeUtils.build(1, 2, 2);
        // ListNode head = ListNodeUtils.build(1, 1, 1, 2, 3, 4, 4, 5);
        ListNodeUtils.display(rdsl.deleteDuplicates(head));
    }

}
