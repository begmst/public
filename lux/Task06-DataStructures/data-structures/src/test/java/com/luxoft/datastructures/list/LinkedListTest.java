package com.luxoft.datastructures.list;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest extends TestCase {

    private LinkedList list;

    @BeforeEach
    protected void setUp() {
        list = new LinkedList();
    }

    @Test
    public void testEmptyList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAndGetElements() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testAddFirstAndLastElements() {
        list.add("A");
        list.add("B");
        list.add("C");

        list.addFirst("AA");
        list.addLast("CC");
        list.add("BB", 2);

        assertEquals("AA", list.get(0));
        assertEquals("A",  list.get(1));
        assertEquals("BB", list.get(2));
        assertEquals("B",  list.get(3));
        assertEquals("C",  list.get(4));
        assertEquals("CC", list.get(5));
    }

    @Test
    public void testIndexOfAndLastIndexOf() {
        list.add("A", "B", "C", "D", "E");

        assertEquals(0, list.indexOf("A"));
        assertEquals(4, list.indexOf("E"));
        assertEquals(0, list.lastIndexOf("A"));
        assertEquals(4, list.lastIndexOf("E"));

        list.add("AA", 2);
        list.addLast("AA");

        assertEquals(2, list.indexOf("AA"));
        assertEquals(6, list.lastIndexOf("AA"));
    }

    @Test
    public void testContains() {
        list.add("A", "B", "C");

        assertTrue(list.contains("A"));
        assertFalse(list.contains("Hello, Java"));

        list.add("Hello, Java");
        assertTrue(list.contains("Hello, Java"));
    }

    @Test
    public void testSet() {
        list.add("A", "B", "C");
        String element = (String) list.set("BB", 1);

        assertTrue(list.contains("BB"));
        assertFalse(list.contains("B"));
        assertEquals("B", element);
    }

    @Test
    public void testToString() {
        list.add("A", "B", "C");

        assertEquals("[A, B, C]", list.toString());
    }

    @Test
    public void testRemove() {
        list.add("A", "B", "C", "D", "E");
        list.remove(1);
        assertEquals(4, list.size());
        assertEquals("C", list.get(1));
        assertFalse(list.contains("B"));

        list.remove(0);
        assertEquals(3, list.size());
        assertEquals("C", list.get(0));
        assertFalse(list.contains("A"));

        list.remove(2);
        assertEquals(2, list.size());
        assertEquals("D", list.get(1));
        assertFalse(list.contains("E"));
    }

    @Test
    public void testClear() {
        list.add("A", "B", "C", "D", "E");

        assertFalse(list.isEmpty());
        assertFalse(list.size() == 0);

        list.clear();

        assertTrue(list.isEmpty());
        assertTrue(list.size() == 0);
    }
}
