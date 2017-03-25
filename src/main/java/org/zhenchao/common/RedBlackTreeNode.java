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

    /** 子树的节点数目 */
    public int size;

    public RedBlackTreeNode(K key, V value, boolean color, int size) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.size = size;
    }

}
