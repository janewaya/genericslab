/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

/**
 *
 * @author janewaya
 */
public class LinkedList<T> {
    
    
    
    private static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
  
    public void intersperse(T sep) {
        if (first == null) {
            first = new Node(sep, null);
        } else {
            Node<T> temp;
            Node<T> temp2;
            temp = first;
            temp2 = first.next;

            while(temp2.next != null) {
               Node<T> i = new Node(sep, temp2);
               temp.next = i;
               temp = temp2;
               temp2 = temp2.next;
            }
            Node<T> i = new Node(sep, temp2);
               temp.next = i;
               temp = temp2;
        
        }
    }
    
    /**
     * Cannot be implemented because finding a maximum assumes our type is an
     * numeric, so something like a String would not work.  
     * @return 
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        String str = "[";
         if (first == null) {
            return "[]";
        } else {
            Node<T> temp;
            temp = first;

            while(temp.next != null) {
               str = str.concat(temp.value.toString() + ", ");
               temp = temp.next;
            }
            str = str.concat(temp.value.toString() + "]");
        
        }
         
         return str;
    }
    
    /**
     * Cannot be implemented because doing insertion sort requires our type is
     * numeric, so something like a String would not work.  
     * @return 
     */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }
}


