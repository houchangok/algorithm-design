### 题目

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given `1->2->3->4`, you should return the list as `2->1->4->3`.

Your algorithm should use only constant space. You may __not__ modify the values in the list, only nodes itself can be changed.

### 分析

题目要求我们交换邻接两个结点的位置，并且要求不能通过交换值的方式实现，必须修改指针的指向，所以整个题目考察的就是遍历链表过程中，指针重定向操作的问题。

### 实现

```java
public ListNode swapPairs(ListNode head) {
    if (null == head || null == head.next) {
        return head;
    }

    ListNode tmp = new ListNode(-1), header = tmp;
    ListNode left = head, right = head.next;
    while (null != left && null != right) {
        // 对调邻接的两个结点
        left.next = right.next;
        right.next = left;

        // 利用一个旁观指针记录新的结点的位置
        tmp.next = right;
        tmp.next.next = left;
        tmp = tmp.next.next;

        // 移动的下一个交换的结点位置
        left = left.next;
        if (null == left) {
            // 如果组合一对不匹配则直接退出循环
            break;
        }
        right = left.next;
    }

    return header.next;
}
```

最初的实现仅适用了left和right两个指针，但是这会因为引用问题，导致最后的结果并不是我们希望的，所以还是需要用一个旁观指针去记录整一个链。