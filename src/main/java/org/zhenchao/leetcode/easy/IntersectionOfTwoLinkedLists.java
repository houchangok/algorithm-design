package org.zhenchao.leetcode.easy;


import org.zhenchao.leetcode.basic.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * @author Apache_xiaochao 2015-10-3 14:23:40
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        while (a.next != null) {
            lenA++;
            a = a.next;
        }
        while (b.next != null) {
            lenB++;
            b = b.next;
        }
        if (a != b) {
            return null;
        }
        a = headA;
        b = headB;
        if (lenA > lenB) {
            int i = 0;
            while (i < (lenA - lenB)) {
                a = a.next;
                i++;
            }
        } else if (lenA < lenB) {
            int i = 0;
            while (i < (lenB - lenA)) {
                b = b.next;
                i++;
            }
        }
        while (a != null) {
            if (a == b) {
                return a;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}
