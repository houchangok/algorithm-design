package org.zhenchao.classic.sliding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhenchao.wang 2018-03-14 17:19
 * @version 1.0.0
 */
public final class SlotBasedCounter<T> {

    private final Map<T, long[]> keyWithCounts = new HashMap<T, long[]>();

    private final int slotCount;

    public SlotBasedCounter(int slotCount) {
        if (slotCount <= 0) {
            throw new IllegalArgumentException("number of slots must be greater than zero: " + slotCount);
        }
        this.slotCount = slotCount;
    }

    /**
     * 将指定 key 对应 slot 位置的计数值加 1
     *
     * @param key
     * @param slot
     */
    public void increment(T key, int slot) {
        long[] counts = keyWithCounts.get(key);
        if (counts == null) {
            counts = new long[slotCount];
            keyWithCounts.put(key, counts);
        }
        counts[slot]++;
    }

    /**
     * 获取指定 key 对应 slot 位置的计数值
     *
     * @param key
     * @param slot
     * @return
     */
    public long getCount(T key, int slot) {
        long[] counts = keyWithCounts.get(key);
        if (counts == null) {
            return 0;
        } else {
            return counts[slot];
        }
    }

    /**
     * 获取各个 key 对应的计数总值
     *
     * @return
     */
    public Map<T, Long> getTotalCount() {
        Map<T, Long> result = new HashMap<T, Long>();
        for (T key : keyWithCounts.keySet()) {
            result.put(key, this.totalCount(key));
        }
        return result;
    }

    /**
     * 将所有 key 指定 slot 位置的计数值置为 0
     *
     * @param slot
     */
    public void wipeAsZero(int slot) {
        for (T key : keyWithCounts.keySet()) {
            keyWithCounts.get(key)[slot] = 0;
        }
    }

    /**
     * 移除所有 totalCount = 0 的 key
     */
    public void clear() {
        Set<T> objToBeRemoved = new HashSet<T>();
        for (T key : keyWithCounts.keySet()) {
            if (this.totalCount(key) == 0) {
                objToBeRemoved.add(key);
            }
        }
        for (T key : objToBeRemoved) {
            keyWithCounts.remove(key);
        }
    }

    private long totalCount(T key) {
        long[] counts = keyWithCounts.get(key);
        long total = 0;
        for (long count : counts) {
            total += count;
        }
        return total;
    }

}
