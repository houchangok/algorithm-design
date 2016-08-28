package org.zhenchao.leetcode.easy;


import org.zhenchao.common.ListNode;

/**
 * Reverse a singly linked list.
 *
 * @author Apache_xiaochao 2015-10-9 20:39:18
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        n1.next = n2;
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode root = rll.reverseList(n1);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode root = head;
        while (p != null) {
            //删除p结点
            root.next = p.next;

            // 将p结点插入到头结点后面
            ListNode q = p;
            p = p.next;

            q.next = head;
            head = q;

        }
        return head;
    }

}
