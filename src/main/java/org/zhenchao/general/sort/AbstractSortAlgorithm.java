package org.zhenchao.general.sort;

/**
 * 排序算法模板
 *
 * @author zhenchao.wang 2017-02-19 14:59
 * @version 1.0.0
 */
public abstract class AbstractSortAlgorithm<T extends Comparable<T>> {

    /**
     * 排序函数
     *
     * @param a
     */
    public abstract void sort(T[] a);

    /**
     * 用于对元素进行比较
     *
     * @param v
     * @param w
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 打印
     *
     * @param a
     */
    protected void show(Comparable<T>[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            if((i + 1) % 40 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 校验是否有序
     *
     * @param a
     * @return
     */
    protected boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
