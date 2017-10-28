### Copy List with Random Pointer

> No.138, medium

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

#### 分析

#### 实现

```java
public RandomListNode copyRandomList(RandomListNode head) {
    if (null == head) return null;
    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    RandomListNode newHead = new RandomListNode(head.label), newPre = newHead;
    map.put(head, newHead);
    RandomListNode old = head.next;
    // 处理next：建立 old 和 new 之间的映射
    while (null != old) {
        RandomListNode node = new RandomListNode(old.label);
        newPre.next = node;
        map.put(old, node);
        newPre = node;
        old = old.next;
    }

    // 处理random
    RandomListNode tmp = newHead;
    while (null != head) {
        tmp.random = map.get(head.random);
        head = head.next;
        tmp = tmp.next;
    }
    return newHead;
}
```
