### 题目

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,

Given 1->2->3->3->4->4->5, return 1->2->5.

Given 1->1->1->2->3, return 2->3.

### 分析

题目主要考察的还是链表的操作，不过这题目主要还是要理清楚到底哪些结点需要删除，主要可以归纳为如下两种：

1. idx.val == idx.next.val
2. idx.val == delete.val

### 实现

```java
public ListNode deleteDuplicates(ListNode head) {
    if (null == head || null == head.next) return head;
    ListNode nh = new ListNode(-1), op = nh, idx = head;
    ListNode delete = null;
    while (idx.next != null) {
        if (idx.val == idx.next.val || (null != delete && idx.val == delete.val)) {
            delete = idx;
        } else {
            op.next = idx;
            op = op.next;
        }
        idx = idx.next;
    }
    if (null == delete || delete.val != idx.val) {
        op.next = idx;
    } else {
        op.next = null;
    }
    return nh.next;
}
```