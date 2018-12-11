package org.zhenchao.algo.j.sliding;

import java.util.Map;
import java.util.Set;

/**
 * @author zhenchao.wang 2018-03-14 11:13
 * @version 1.0.0
 */
public class SlidingWindowSet<K, V> {

    private SlotBasedSet<K, V> objSet;
    private int head, tail;
    private int windowLength;

    public SlidingWindowSet(int windowLength) {
        if (windowLength < 2) {
            throw new IllegalArgumentException("window length must be at least two: " + windowLength);
        }
        this.windowLength = windowLength;
        this.objSet = new SlotBasedSet<K, V>(this.windowLength);

        this.head = 0;
        this.tail = this.nextSlotValue(head);
    }

    public void add(K key, V value) {
        objSet.add(key, head, value);
    }

    /**
     * Return the current (total) sets of all tracked objects, then advance the window.
     * <p/>
     * Whenever this method is called, we consider the sets of the current sliding window to be available to and
     * successfully processed "upstream" (i.e. by the caller). Knowing this we will start counting any subsequent
     * objects within the next "chunk" of the sliding window.
     *
     * @return The current (total) sets of all tracked objects.
     */
    public Map<K, Set<V>> getSetsThenMoveWindow() {
        objSet.wipeZeros();
        Map<K, Set<V>> counts = objSet.getSets();
        objSet.wipeSlot(tail);
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
