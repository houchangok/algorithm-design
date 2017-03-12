package org.zhenchao.common;

/**
 * 基本操作
 *
 * @author zhenchao.wang 2017-03-12 10:52
 * @version 1.0.0
 */
public abstract class BasicOperation<T extends Comparable<T>> {

    /**
     * 用于对元素进行比较
     *
     * @param v
     * @param w
     */
    public boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    public void exchange(Comparable<T>[] a, int i, int j) {
        Comparable<T> tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 打印
     *
     * @param a
     */
    public void show(Comparable<T>[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            if ((i + 1) % 40 == 0) {
                System.out.println();
            }
        }
    }

}
