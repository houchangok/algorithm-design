package org.zhenchao.general.sort;

/**
 * 希尔排序
 *
 * @author zhenchao.wang 2017-02-19 18:30
 * @version 1.0.0
 */
public class ShellSort extends AbstractSortAlgorithm<Integer> {

    @Override
    public void sort(Integer[] a) {
        // 构造区间，区间对于排序性能影响较大
        int interval = 1;
        while (interval < a.length / 3) {
            interval = 3 * interval + 1;
        }

        while (interval >= 1) {
            for (int i = interval; i < a.length; i++) {
                for (int j = i; j >= interval && this.less(a[j], a[j - interval]); j -= interval) {
                    this.exch(a, j, j - interval);
                }
            }
            interval /= 3;  // 区间收敛
        }
    }

}
