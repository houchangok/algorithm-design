package org.zhenchao.general.sort;

/**
 * 快速排序
 *
 * @author zhenchao.wang 2017-02-26 20:13
 * @version 1.0.0
 */
public class QuickSort extends AbstractSortAlgorithm<Integer> {

    /**
     * 每次都选择当前数组的第一个元素作为标杆，让数组中该数左边的元素都不大于该数，右边的数都不小于该数
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public int partition(Integer[] a, int left, int right) {
        int tmp = a[left];
        int i = left, j = right;
        while (i < j) {
            // 从右边开始
            while (a[j] >= tmp && j > left) {
                j--;
            }
            // 然后左边
            while (a[i] <= tmp && i < right) {
                i++;
            }
            if (i < j) {
                this.exch(a, i, j);
            }
        }
        this.exch(a, left, j);
        return j;
    }

    /**
     * 分治思想
     *
     * @param a
     * @param left
     * @param right
     */
    private void sort(Integer[] a, int left, int right) {
        if (right <= 0 || left >= right) {
            return;
        }
        int index = this.partition(a, left, right);
        this.sort(a, left, index - 1);
        this.sort(a, index + 1, right);
    }

    @Override
    public void sort(Integer[] a) {
        this.sort(a, 0, a.length - 1);
    }

}
