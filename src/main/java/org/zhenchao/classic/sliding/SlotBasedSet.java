package org.zhenchao.classic.sliding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhenchao.wang 2018-03-14 11:04
 * @version 1.0.0
 */
public final class SlotBasedSet<K, V> {

    private final Map<K, Set<V>[]> objToSets = new HashMap<K, Set<V>[]>();

    private final int numSlots;

    public SlotBasedSet(int numSlots) {
        if (numSlots <= 0) {
            throw new IllegalArgumentException("num of slots must be greater than zero: " + numSlots);
        }
        this.numSlots = numSlots;
    }

    @SuppressWarnings("unchecked")
    public void add(K key, int slot, V value) {
        Set<V>[] sets = objToSets.get(key);
        if (sets == null) {
            sets = new Set[this.numSlots];
            for (int i = 0; i < this.numSlots; ++i) {
                sets[i] = new HashSet<V>();
            }
            objToSets.put(key, sets);
        }
        sets[slot].add(value);
    }

    @SuppressWarnings("unchecked")
    public Set<V> getSets(K key, int slot) {
        Set[] sets = objToSets.get(key);
        return null == sets ? null : sets[slot];
    }

    public Map<K, Set<V>> getSets() {
        Map<K, Set<V>> result = new HashMap<K, Set<V>>();
        for (K key : objToSets.keySet()) {
            result.put(key, this.flapToSet(key));
        }
        return result;
    }

    private Set<V> flapToSet(K key) {
        Set<V>[] curr = objToSets.get(key);
        Set<V> sets = new HashSet<V>();
        for (Set<V> cur : curr) {
            sets.addAll(cur);
        }
        return sets;
    }

    public void wipeSlot(int slot) {
        for (K key : objToSets.keySet()) {
            objToSets.get(key)[slot].clear();
        }
    }

    public void wipeZeros() {
        Set<K> objToBeRemoved = new HashSet<K>();
        for (K key : objToSets.keySet()) {
            if (this.shouldBeRemovedFromCounter(key)) {
                objToBeRemoved.add(key);
            }
        }
        for (K key : objToBeRemoved) {
            objToSets.remove(key);
        }
    }

    private boolean shouldBeRemovedFromCounter(K key) {
        Set<V>[] curr = objToSets.get(key);
        for (Set<V> cur : curr) {
            if (null != cur && cur.size() > 0) {
                return false;
            }
        }
        return true;
    }

}
