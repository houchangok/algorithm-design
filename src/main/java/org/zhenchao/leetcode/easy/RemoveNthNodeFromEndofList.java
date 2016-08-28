package org.zhenchao.leetcode.easy;

import org.zhenchao.common.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * @author Apache_xiaochao 2015-10-10 00:26:22
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
        ListNode head = r.removeNthFromEnd(n1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int len = 0;
        int nn = n;
        while (nn >= 0 && first != null) {
            first = first.next;
            nn--;
            len++;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
            len++;
        }
        //当n与链表长度相等时，即表示删除第一个结点
        if (len == n) {
            return head.next;
        }
        if (second.next == null) {
            //表示链表只有一个结点，且删除该结点
            head = null;
        } else {
            second.next = second.next.next;
        }
        return head;
    }

}
