package org.zhenchao.algorithm.Learning;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 14:57
 * @Description:
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRU(int capacity, float loadFactor) {
        super(capacity, loadFactor, true);
        this.capacity = capacity;

    }


    /**
     * 删除的其实是链表的第一个节点
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }
}
