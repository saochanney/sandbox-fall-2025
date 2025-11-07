package org.example.sandbox.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    // O(1) time complexity
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // O(1) time complexity
    @Override
    public void addFirst(E element) {

        Node node = new Node(element, head); // 1 & 2 O(1)

        if (head == null) { // 3 O(1)
            head = node; // O(1)
            tail = node; // O(1)
        } else {
            head = node; // O(1)
        }
        size++; // O(1)

    }

    // O(1) time complexity
    @Override
    public void addLast(E element) {

        Node node = new Node(element, null); // 1

        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node; // 2
            tail = node; // 3
        }
        size++;


    }

    // O(1)
    @Override
    public E pollFirst() {

        E element;
        if (head == null) {
            element = null;
        } else {
            element = head.element;

            if (head == tail) { // only one element - 4
                head = null;
                tail = null;
            } else {
                Node next = head.next; // 2
                head.next = null; // 3
                head = next; // 4
            }
            size--;
        }

        return element;
    }

    // O(n)
    @Override
    public E pollLast() {

        E element;
        if (tail == null) {
            element = null;
        } else {
            element = tail.element; // 1

            if (head == tail) { // 3
                head = null;
                tail = null;
            } else {
                Node current = head;
                Node previous = head;
                while(current.next != null) { // O(n)
                    previous = current; // 2
                    current = current.next; // 2
                }
                tail = previous; // 3
                tail.next = null; // 4
            }
            size--;
        }


        return element;
    }

    // O(1)
    @Override
    public E peekFirst() {

        E element;
        if (head == null) {
            element = null;
        } else {
            element =  head.element;
        }

        return element;
    }

    //O(1)
    @Override
    public E peekLast() {

        E element;
        if (tail == null) {
            element = null;
        } else {
            element = tail.element;
        }
        return element;
    }

    // O(n)
    @Override
    public void clear() {

        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.element = null;
            current.next = null; // breaks links
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    // O(n)
    @Override
    public boolean contains(E element) {

        boolean contains = false;

        Node current = head;
        while(current != null) {
            if (current.element == element) {
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }

    //O(1)
    @Override
    public int size() {
        return this.size;
    }

    // O(n) + 2*O(m) = O(n)
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");  // O(m)
        StringJoiner joiner = new StringJoiner(", "); // O(m)

        Node current = head;
        if (current != null) {
            while (current != null) { // O(n)
                joiner.add(current.element.toString());
                current = current.next;
            }
        }
        builder.append(joiner);
        builder.append("]");
        return builder.toString();

    }

    private class Node {

        E element;
        Node next;

        public Node(E element, Node next) { // O(1)
            this.element = element; // O(1)
            this.next = next; // O(1)
        }
    }
}
