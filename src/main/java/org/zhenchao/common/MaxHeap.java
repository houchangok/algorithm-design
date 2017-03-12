package org.zhenchao.common;

/**
 * 最大堆
 *
 * @author zhenchao.wang 2017-03-05 15:34
 * @version 1.0.0
 */
public class MaxHeap<T extends Comparable<T>> extends BasicOperation<T> {

    private T[] array;

    /**
     * 上浮
     * 对于新元素，插入到数组的尾部，然后通过上浮让新元素到达合适的位置
     *
     * @param n
     */
    public void swim(int n) {
        int k = n;
        while (k / 2 > 0 && this.less(array[k / 2], array[k])) {
            this.exchange(array, k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉
     * 如果从数组顶端删除最大元素，同时将最后一个元素放置到顶端，然后通过下沉将该元素达到合适的位置
     *
     * @param n
     */
    public void sink(int n) {
        int k = n;
        while (2 * k <= array.length) {
            int i = 2 * k;
            if (this.less(array[k], array[i])) {
                this.exchange(array, k, i);
                k = i;
            }
            int j = 2 * k + 1;
            if (j > n) {
                break;
            }
            if (this.less(array[k], array[j])) {
                this.exchange(array, k, j);
                k = j;
            }
        }
    }

}
