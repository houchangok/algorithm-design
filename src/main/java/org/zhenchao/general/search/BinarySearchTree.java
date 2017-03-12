package org.zhenchao.general.search;

import org.zhenchao.common.BSTreeNode;

/**
 * 二叉查找树
 *
 * @author zhenchao.wang 2017-03-12 18:17
 * @version 1.0.0
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    private BSTreeNode<K, V> root;

    public BinarySearchTree(BSTreeNode<K, V> root) {
        this.root = root;
    }

    @Override
    public void put(K key, V value) {
        this.put(root, key, value);
    }

    private void put(BSTreeNode<K, V> node, K key, V value) {
        int cValue = key.compareTo(node.key);
        if (cValue > 0) {
            if (null == node.right) {
                node.right = new BSTreeNode<K, V>(key, value, null, null, 0);
            } else {
                this.put(node.right, key, value);
            }
        } else if (cValue < 0) {
            if (null == node.left) {
                node.left = new BSTreeNode<K, V>(key, value, null, null, 0);
            } else {
                this.put(node.left, key, value);
            }
        } else {
            if (null != value) {
                node.value = value;
            }
        }
    }

    @Override
    public V get(K key) {
        return this.get(root, key);
    }

    private V get(BSTreeNode<K, V> node, K key) {
        int cValue = key.compareTo(node.key);
        if (cValue > 0) {
            return this.get(node.right, key);
        } else if (cValue < 0) {
            return this.get(node.left, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(K lo, K hi) {
        return 0;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    /**
     * 中序遍历
     */
    public void inorderTraverse() {
        this.inorderTraverse(root);
    }

    private void inorderTraverse(BSTreeNode<K, V> node) {
        if (null != node.left) {
            this.inorderTraverse(node.left);
        }
        System.out.print(node.key + ", ");
        if (null != node.right) {
            this.inorderTraverse(node.right);
        }
    }
}
