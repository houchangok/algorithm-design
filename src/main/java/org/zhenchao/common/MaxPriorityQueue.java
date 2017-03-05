package org.zhenchao.common;

/**
 * 最大优先级队列
 *
 * @author zhenchao.wang 2017-03-05 14:15
 * @version 1.0.0
 */
public class MaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] array[];  // 利用数组形式存储小端堆

    private int N = 0;

    public MaxPriorityQueue() {
    }

    public MaxPriorityQueue(int size) {
    }

    public MaxPriorityQueue(T[] init) {
    }

    @Override
    public void insert(T value) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 返回当前队列最大的元素
     *
     * @return
     */
    public T max() {
        return null;
    }

    /**
     * 删除当前队列最大的元素
     *
     * @return
     */
    public T delMax() {
        return null;
    }

}
