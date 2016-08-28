package org.zhenchao.general;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 基础排序算法
 *
 * @author zhenchao.Wang  2016-8-28 17:09:14
 */
public class SortAlgorithm {

    /**
     * 希尔排序
     *
     * @param array:待排序数组
     */
    public void shellSort(int[] array) {

        //确定执行简单插入排序的轮询次数，log2
        int n = (int) (Math.log10(array.length) / Math.log10(2));

        //每次轮询设置的简单插入排序的成员个数满足2的幂，...8,4,2,1(逆序)
        for (int i = n; i >= 0; i--) {
            int span = (int) Math.pow(2, i);
            for (int j = 0; j < array.length - span; j++) {
                for (int k = j + span; k < array.length; k += span) {
                    for (int l = k; l >= span; l -= span) {
                        //使用简单插入排序
                        if (array[l] < array[l - span]) {
                            int temp = array[l];
                            array[l] = array[l - span];
                            array[l - span] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 创建最大堆
     *
     * @param a
     * @param i
     */
    private static void buildMaxHeap(ArrayList<Integer> a, int i) {
        if (i < 0)
            return;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < a.size()) {
            if (r < a.size()) {
                int max = Math.max(a.get(l), a.get(r));
                if (max > a.get(i)) {
                    if (a.get(l) == max) {
                        a.set(l, a.get(i));
                        a.set(i, max);
                        buildMaxHeap(a, l);
                    } else {
                        a.set(r, a.get(i));
                        a.set(i, max);
                        buildMaxHeap(a, r);
                    }
                } else {
                    buildMaxHeap(a, --i);
                }
            } else {
                if (a.get(i) < a.get(l)) {
                    int temp = a.get(i);
                    a.set(i, a.get(l));
                    a.set(l, temp);
                    buildMaxHeap(a, l);
                } else {
                    buildMaxHeap(a, --i);
                }
            }
        } else {
            --i;
            buildMaxHeap(a, i);
        }
    }

    /**
     * 堆排序
     *
     * @param input
     */
    private static LinkedList<Integer> heapSort(ArrayList<Integer> input) {
        LinkedList<Integer> list = null;
        if (input != null) {
            list = new LinkedList<Integer>();
        }
        while (input.size() > 0) {
            int startIndex = input.size() / 2 - 1;
            buildMaxHeap(input, startIndex); //构建最大堆
            //交换堆中第一个和最后一个元素
            int lastIndex = input.size() - 1;
            int temp = input.get(lastIndex);
            input.set(lastIndex, input.get(0));
            input.set(0, temp);
            //截取堆中的最后一个元素
            list.addFirst(input.remove(lastIndex));
        }
        return list;
    }

    /**
     * 快速排序
     *
     * @param input
     * @param left
     * @param right
     */
    public static void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        int temp = input[l];  //以第一个元素作为种子元素
        int cl = l;  //记录当前种子元素所处于的位置
        while (l < r) {
            //先从右边开始
            while (input[r] >= temp && r > cl) {
                --r;  //当右边元素值大于种子元素时，右指针左移
            }
            //遇到右边元素小于种子元素，交换
            input[cl] = input[r];
            cl = r;

            //再从左边开始
            while (input[l] <= temp && l < cl) {
                ++l;  //当左边元素值小于种子元素时，左指针右移
            }
            //当遇到左边元素大于种子元素，交换
            input[cl] = input[l];
            cl = l;
        }
        //一次排序完成，将种子元素放到应该所属的位置
        input[cl] = temp;

        //递归
        quickSort(input, left, cl - 1);
        quickSort(input, cl + 1, right);
    }

}
