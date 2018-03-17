package org.zhenchao.common;

/**
 * 红黑树结点
 *
 * @author zhenchao.wang 2017-03-18 18:42
 * @version 1.0.0
 */
public class RBTreeNode<K extends Comparable<K>, V> {

    public enum Color {
        RED,
        BLACK
    }

    private K key;
    private V value;

    /** 父节点指向该结点的颜色 */
    private Color color = Color.BLACK;

    /** 子树的节点数目 */
    private int size;

    private RBTreeNode<K, V> left, right;

    public RBTreeNode(K key, V value, Color color, int size) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.size = size;
    }

    public K getKey() {
        return key;
    }

    public RBTreeNode setKey(K key) {
        this.key = key;
        return this;
    }

    public V getValue() {
        return value;
    }

    public RBTreeNode setValue(V value) {
        this.value = value;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public RBTreeNode setColor(Color color) {
        this.color = color;
        return this;
    }

    public int getSize() {
        return size;
    }

    public RBTreeNode setSize(int size) {
        this.size = size;
        return this;
    }

    public RBTreeNode<K, V> getLeft() {
        return left;
    }

    public RBTreeNode setLeft(RBTreeNode<K, V> left) {
        this.left = left;
        return this;
    }

    public RBTreeNode<K, V> getRight() {
        return right;
    }

    public RBTreeNode setRight(RBTreeNode<K, V> right) {
        this.right = right;
        return this;
    }
}
