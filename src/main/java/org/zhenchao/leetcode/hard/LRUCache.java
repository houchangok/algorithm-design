package org.zhenchao.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the val (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, val) - Set or insert the val if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * @author Apache_xiaochao 2015-10-8 18:56:48
 */
public class LRUCache {

    private int                capacity;  // Cache的大小
    private Map<Integer, Node> keys;
    private Node               root;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keys = new HashMap<Integer, Node>(capacity);
        this.root = new Node(-1, -1);
        this.root.pre = this.root;
        this.root.next = this.root;
    }

    /**
     * 获取指定key对应的value
     * 如果没有就返回-1，如果有的话就返回value，同时将结点置为最上面位置
     *
     * @param key
     *
     * @return
     */
    public int get(int key) {
        Node node = this.keys.get(key);
        if (node == null) {
            return -1;
        }
        if (node.pre == this.root) {
            return node.data;
        }
        // 删除当前结点
        node.next.pre = node.pre;
        node.pre.next = node.next;
        // 将当前结点至于开头
        this.root.next.pre = node;
        node.next = this.root.next;
        node.pre = this.root;
        this.root.next = node;
        return node.data;
    }

    /**
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        Node node = this.keys.get(key);
        if (node != null && node.data == value) {
            return;
        } else if (node != null && node.data != value) {
            // 修改结点的值，同时至于最上面的位置
            node.data = value;

            // 删除当前结点
            node.next.pre = node.pre;
            node.pre.next = node.next;

            // 将当前结点至于开头
            this.root.next.pre = node;
            node.next = this.root.next;
            node.pre = this.root;
            this.root.next = node;

        } else {
            // 结点不存在
            if (this.keys.size() < this.capacity) {
                // 直接在最开始的位置添加一个结点
                node = new Node(key, value);

                // 将当前结点至于开头
                this.root.next.pre = node;
                node.next = this.root.next;
                node.pre = this.root;
                this.root.next = node;

                // 往hash表添加一个当前结点的句柄
                this.keys.put(key, node);

            } else {
                // 删除最近最少使用的那个结点
                Node dNode = this.root.pre;
                this.root.pre = dNode.pre;
                dNode.pre.next = this.root;

                // 删除结点在HashMap中的句柄
                this.keys.remove(dNode.key);

                //删除最近最少使用的结点，同时在最开始的位置添加一个结点
                node = new Node(key, value);

                // 将当前结点至于开头
                this.root.next.pre = node;
                node.next = this.root.next;
                node.pre = this.root;
                this.root.next = node;

                // 添加新的结点的句柄到HashMap
                this.keys.put(key, node);

            }
        }
    }

}

/**
 * 自定义双向链表结点
 *
 * @author Apache_xiaochao 2015-10-8 19:18:46
 */
class Node {
    int  key;
    int  data;
    Node pre;
    Node next;

    public Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}
