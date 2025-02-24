/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author janewaya
 */
public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList l = new LinkedList();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10NumsAsStrings() {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveral() {
        LinkedList l = new LinkedList();
        String[] elements = new String[] {"a", "b", "c", "d", "e", "f", "g"};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        LinkedList l = new LinkedList();
        l.add("hello!");
        l.add("goodbye!");
        l.add("huh?");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedList l = new LinkedList();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));
        
        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedList l = new LinkedList();
        l.add("A");
        l.add("B");
        l.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }
    @Test
        public void test() {
        LinkedList l = new LinkedList();
        l.add("A");
        l.add("B");
        l.add("B.5");
        l.add("C");
        l.intersperse(3);
        System.out.println(l.toString());
        assertEquals("A", l.get(0));
    }
}
