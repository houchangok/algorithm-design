package org.zhenchao.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 队列
 *
 * @author zhenchao.wang 2017-02-19 10:41
 * @version 1.0.0
 */
public class Queue<T> implements Iterable<T> {

    private Node<T> first;    // beginning of queue

    private Node<T> last;     // end of queue

    private int size;         // number of elements on queue

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.value;
    }

    /**
     * Adds the item to this queue.
     *
     * @param value the item to add
     */
    public void enqueue(T value) {
        Node<T> pre = last;
        last = new Node<T>(value);
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            pre.next = last;
        }
        size++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        T value = first.value;
        first = first.next;
        size--;
        if (this.isEmpty()) {
            last = null;   // to avoid loitering
        }
        return value;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T value : this) {
            builder.append(value);
            builder.append(' ');
        }
        return builder.toString();
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}