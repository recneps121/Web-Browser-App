package com.example.assignment2;

public class LinkedList {

    private Node head;
    private Node current;
    private Node tail;
    private int currentIndex;
    private int numNodes;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.numNodes = 0;
        this.current = null;
        this.currentIndex = -1;
    }

    private class Node {

        Node next;
        Node previous;
        Object value;
    }

    public boolean hasNext() {
        return (current != null && current.next != null);
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new IllegalStateException("No next");
        }

        current = current.next;
        return current.value;

    }

    public boolean hasPrevious() {
        return (current != null && current.previous != null);

    }

    public Object previous() {
        if (!this.hasPrevious()) {
            throw new IllegalStateException("No previous");
        }
        current = current.previous;
        return current.value;

    }


    public void add(Object o) {
        Node newNode = new Node();
        newNode.value = o;
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = null;

        } else if (head != null) {
            if (current == null) {
                newNode.previous = null;
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else if (current == tail) {
                newNode.previous = current;
                newNode.next = null;
                current.next = newNode;
                tail = newNode;
            } else {
                newNode.previous = current;
                newNode.next = current.next;
                current.next.previous = newNode;
                current.next = newNode;
            }
        }
        current = newNode;
        numNodes++;
        currentIndex++;

    }
}
