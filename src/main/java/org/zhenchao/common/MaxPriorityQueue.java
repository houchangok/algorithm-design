package org.zhenchao.common;

/**
 * 最大优先级队列
 *
 * @author zhenchao.wang 2017-03-05 14:15
 * @version 1.0.0
 */
public class MaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] array;  // 利用数组形式存储小端堆

    private int size = 0;  // 0位置不存放元素

    public MaxPriorityQueue() {
    }

    public MaxPriorityQueue(int size) {
        this.array = (T[]) new Comparable[size + 1];
        this.size = size;
    }

    public MaxPriorityQueue(T[] init) {
        this.array = init;
        this.size = this.array.length - 1;
    }

    @Override
    public void insert(T value) {

    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * 返回当前队列最大的元素
     *
     * @return
     */
    public T max() {
        if(this.isEmpty()) {
            return null;
        }
        return array[1];
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
