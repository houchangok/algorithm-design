package org.zhenchao.classic.search;

import org.zhenchao.common.RedBlackTreeNode;

import java.util.NoSuchElementException;

/**
 * 红黑树
 *
 * @author zhenchao.wang 2017-03-25 15:32
 * @version 1.0.0
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private RedBlackTreeNode<K, V> root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * 查找key对应的value
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null!");
        }
        return this.get(root, key);
    }

    private V get(RedBlackTreeNode<K, V> node, K key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 是否包含指定的key
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    /**
     * 插入结点
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        root = this.put(root, key, value);
        root.color = BLACK;
    }

    private RedBlackTreeNode<K, V> put(RedBlackTreeNode<K, V> node, K key, V value) {

        if (null == node) {
            return new RedBlackTreeNode<K, V>(key, value, RED, 1);
        }

        // 1. 插入结点

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            // 左插入
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            // 右插入
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        // 2. 再平衡

        if (this.isRed(node.right) && this.isBlack(node.left)) {
            node = this.rotateLeft(node);
        }

        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
        }

        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColors(node);
        }

        node.size = this.size(node.left) + this.size(node.right) + 1;
        return node;
    }

    /**
     * 删除指定的结点
     *
     * @param key
     */
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!this.contains(key)) {
            return;
        }

        if (this.isBlack(root.left) && this.isBlack(root.right)) {
            root.color = RED;
        }

        root = this.delete(root, key);
        if (!this.isEmpty()) {
            root.color = BLACK;
        }
    }

    private RedBlackTreeNode<K, V> delete(RedBlackTreeNode<K, V> node, K key) {

        if (key.compareTo(node.key) < 0) {
            if (this.isBlack(node.left) && this.isBlack(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        } else {
            if (this.isRed(node.left)) {
                node = this.rotateRight(node);
            }
            if (key.compareTo(node.key) == 0 && (node.right == null)) {
                return null;
            }
            if (this.isBlack(node.right) && this.isBlack(node.right.left)) {
                node = moveRedRight(node);
            }
            if (key.compareTo(node.key) == 0) {
                RedBlackTreeNode<K, V> x = this.min(node.right);
                node.key = x.key;
                node.value = x.value;
                node.right = this.deleteMin(node.right);
            } else {
                node.right = this.delete(node.right, key);
            }
        }
        return this.balance(node);
    }

    /**
     * 删除最小的结点
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (this.isBlack(root.left) && this.isBlack(root.right)) {
            root.color = RED;
        }

        root = this.deleteMin(root);
        if (!this.isEmpty()) {
            root.color = BLACK;
        }
    }

    private RedBlackTreeNode<K, V> deleteMin(RedBlackTreeNode<K, V> node) {
        if (node.left == null) {
            return null;
        }

        if (this.isBlack(node.left) && this.isBlack(node.left.left)) {
            node = this.moveRedLeft(node);
        }

        node.left = deleteMin(node.left);
        return this.balance(node);
    }

    /**
     * 删除最大的结点
     */
    public void deleteMax() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        if (this.isBlack(root.left) && this.isBlack(root.right)) {
            root.color = RED;
        }

        root = this.deleteMax(root);
        if (!this.isEmpty()) {
            root.color = BLACK;
        }
    }

    private RedBlackTreeNode<K, V> deleteMax(RedBlackTreeNode<K, V> node) {
        if (this.isRed(node.left)) {
            node = this.rotateRight(node);
        }

        if (node.right == null) {
            return null;
        }

        if (this.isBlack(node.right) && this.isBlack(node.right.left)) {
            node = moveRedRight(node);
        }

        node.right = deleteMax(node.right);

        return this.balance(node);
    }

    /**
     * 返回最小的key
     *
     * @return
     */
    public K min() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("called min() with empty symbol table");
        }
        return this.min(root).key;
    }

    private RedBlackTreeNode<K, V> min(RedBlackTreeNode<K, V> node) {
        return null == node.left ? node : this.min(node.left);
    }

    /**
     * 返回最大的key
     *
     * @return
     */
    public K max() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("called max() with empty symbol table");
        }
        return max(root).key;
    }

    private RedBlackTreeNode<K, V> max(RedBlackTreeNode<K, V> node) {
        return null == node.right ? node : this.max(node.right);
    }

    /**
     * 获取树的总结点数
     *
     * @return
     */
    public int size() {
        return this.size(root);
    }

    /**
     * 返回当前节点子节点的数目，若没有子节点则返回0
     *
     * @param node
     * @return
     */
    private int size(RedBlackTreeNode<K, V> node) {
        if (null == node) {
            return 0;
        }
        return node.size;
    }

    /**
     * 是否是一棵空树
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 左旋转
     *
     * @param node
     * @return
     */
    private RedBlackTreeNode<K, V> rotateLeft(RedBlackTreeNode<K, V> node) {
        RedBlackTreeNode<K, V> parent = node.right;
        node.right = parent.left;
        parent.left = node;
        parent.color = node.color;
        node.color = RED;
        parent.size = node.size;
        node.size = 1 + this.size(node.left) + this.size(node.right);
        return parent;
    }

    /**
     * 右旋转
     *
     * @param node
     * @return
     */
    private RedBlackTreeNode<K, V> rotateRight(RedBlackTreeNode<K, V> node) {
        RedBlackTreeNode<K, V> parent = node.left;
        node.left = parent.right;
        parent.right = node;
        parent.color = node.color;
        node.color = RED;
        parent.size = node.size;
        node.size = 1 + this.size(node.left) + this.size(node.right);
        return parent;
    }

    /**
     * 颜色转换
     * 将节点node的两个子节点颜色变黑，并将自己的颜色变为红色
     *
     * @param node
     */
    private void flipColors(RedBlackTreeNode<K, V> node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 判断是否是红结点
     *
     * @param node
     * @return
     */
    private boolean isRed(RedBlackTreeNode<K, V> node) {
        if (null == node) {
            return false;
        }
        return node.color;
    }

    /**
     * 判断是否是黑结点
     *
     * @param node
     * @return
     */
    private boolean isBlack(RedBlackTreeNode<K, V> node) {
        return !this.isRed(node);
    }

    private RedBlackTreeNode<K, V> moveRedLeft(RedBlackTreeNode<K, V> node) {
        this.flipColors(node);
        if (this.isRed(node.right.left)) {
            node.right = this.rotateRight(node.right);
            node = this.rotateLeft(node);
            this.flipColors(node);
        }
        return node;
    }

    private RedBlackTreeNode<K, V> moveRedRight(RedBlackTreeNode<K, V> node) {
        this.flipColors(node);
        if (this.isRed(node.left.left)) {
            node = this.rotateRight(node);
            this.flipColors(node);
        }
        return node;
    }

    private RedBlackTreeNode<K, V> balance(RedBlackTreeNode<K, V> node) {
        if (this.isRed(node.right)) {
            node = this.rotateLeft(node);
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
        }
        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColors(node);
        }

        node.size = this.size(node.left) + this.size(node.right) + 1;
        return node;
    }
}
