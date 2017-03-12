package org.zhenchao.general.search;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.zhenchao.common.BSTreeNode;

/**
 * @author zhenchao.wang 2017-03-12 21:04
 * @version 1.0.0
 */
public class BinarySearchTreeTest {

    @Test
    public void test() throws Exception {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>(
                new BSTreeNode<Integer, Integer>(RandomUtils.nextInt(0, 100), RandomUtils.nextInt(0, 100), null, null, 1));
        for (int i = 0; i < 100; i++) {
            bst.put(RandomUtils.nextInt(0, 100), RandomUtils.nextInt(0, 100));
        }
        bst.inorderTraverse();
    }

}