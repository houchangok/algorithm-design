package org.zhenchao.common;

/**
 * 红黑树结点
 *
 * @author zhenchao.wang 2017-03-18 18:42
 * @version 1.0.0
 */
public class RedBlackTreeNode<K extends Comparable<K>, V> {

    public K key;

    public V value;

    public RedBlackTreeNode<K, V> left;
    public RedBlackTreeNode<K, V> right;

    /** 父节点指向该结点的颜色，true为红色，false为黑色 */
    public boolean color;

    public RedBlackTreeNode(K key, V value, RedBlackTreeNode<K, V> left, RedBlackTreeNode<K, V> right, boolean color) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }

    public boolean isRed(RedBlackTreeNode<K, V> node) {
        if (null == node) {
            return false;
        }
        return node.color;
    }
}
