package org.zhenchao.algorithm.sliding;

import java.util.Map;

/**
 * @author zhenchao.wang 2018-03-14 17:20
 * @version 1.0.0
 */
public final class SlidingWindowCounter<T> {

    private SlotBasedCounter<T> counter;
    private int head, tail;
    private int windowLength;

    public SlidingWindowCounter(int windowLength) {
        if (windowLength < 2) {
            throw new IllegalArgumentException("window length must be at least two: " + windowLength);
        }
        this.windowLength = windowLength;
        this.counter = new SlotBasedCounter<T>(this.windowLength);

        this.head = 0;
        this.tail = this.nextSlotValue(head);
    }

    /**
     * 将指定 key 的 head 位置加 1
     *
     * @param key
     */
    public void increment(T key) {
        counter.increment(key, head);
    }

    /**
     * Return the current (total) counts of all tracked objects, then advance the window.
     * <p/>
     * Whenever this method is called, we consider the counts of the current sliding window to be available to and
     * successfully processed "upstream" (i.e. by the caller). Knowing this we will start counting any subsequent
     * objects within the next "chunk" of the sliding window.
     *
     * @return The current (total) counts of all tracked objects.
     */
    public Map<T, Long> getTotalCountThenMoveWindow() {
        Map<T, Long> counts = counter.getTotalCount();
        // 清除所有 totalCount = 0 的 key
        counter.clear();
        // 将所有 key 在 tail 位置的计数值置为 0
        counter.wipeAsZero(tail);
        this.advanceHead();
        return counts;
    }

    private void advanceHead() {
        head = tail;
        tail = this.nextSlotValue(tail);
    }

    private int nextSlotValue(int slot) {
        return (slot + 1) % windowLength;
    }

}
