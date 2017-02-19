package org.zhenchao.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 栈
 *
 * @author zhenchao.wang 2017-02-19 10:28
 * @version 1.0.0
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> first;     // top of stack

    private int size;          // size of the stack

    public Stack() {
        first = null;
        size = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return size;
    }

    /**
     * Adds the item to this stack.
     *
     * @param value the item to add
     */
    public void push(T value) {
        Node<T> pre = first;
        first = new Node<T>(value);
        first.next = pre;
        size++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        T value = first.value;        // save item to return
        first = first.next;            // delete first node
        size--;
        return value;                   // return the saved item
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.value;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
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
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    /**
     * 迭代器
     *
     * @param <T>
     */
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