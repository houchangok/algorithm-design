package org.zhenchao.general.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author zhenchao.wang 2017-02-19 15:38
 * @version 1.0.0
 */
public class SortAlgorithmTest {

    private static final int SIZE = 1000;

    private Integer[] array = new Integer[SIZE];

    @Before
    public void setUp() throws Exception {
        // 构造随机数组
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(1000);
        }
    }

    @Test
    public void selectionSortTest() throws Exception {
        SelectionShort ss = new SelectionShort();
        ss.sort(array);
        ss.show(array);
        Assert.assertTrue(ss.isSorted(array));
    }

    @Test
    public void insertionSortTest() throws Exception {
        InsertionSort is = new InsertionSort();
        is.sort(array);
        is.show(array);
        Assert.assertTrue(is.isSorted(array));
    }

    @Test
    public void shellSortTest() throws Exception {
        ShellSort ss = new ShellSort();
        ss.sort(array);
        ss.show(array);
        Assert.assertTrue(ss.isSorted(array));
    }

}