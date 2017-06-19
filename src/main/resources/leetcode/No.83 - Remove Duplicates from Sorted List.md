### 题目

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.

Given 1->1->2->3->3, return 1->2->3.

### 分析

相对于 82 来说要简单很多。

### 实现

```java
public ListNode deleteDuplicates(ListNode head) {
    if (null == head || null == head.next) return head;
    ListNode op = head, pre = head, idx = head.next;
    while (idx != null) {
        if (pre.val != idx.val) {
            op.next = idx;
            op = op.next;
            pre = idx;
        }
        idx = idx.next;
    }
    if(op.next != null) op.next = null;
    return head;
}
```