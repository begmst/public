package com.luxoft.datastructures.list;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest extends TestCase {

    private ArrayList list;

    @BeforeEach
    protected void setUp() throws Exception {
        this.list = new ArrayList(2);
    }

    @Test
    public void testEmptyList() {
        assertTrue(this.list.isEmpty());
        assertEquals(0, this.list.size());
    }

    @Test
    public void testAddValues() {
        this.list.add("A");
        assertEquals(1, this.list.size());
        this.list.add("B");
        assertEquals(2, this.list.size());
        this.list.add("C");
        assertEquals(3, this.list.size());
    }

    @Test
    public void testAddByIndexValues() {
        this.list.add("A");
        this.list.add("B");
        this.list.add("C", 1);
        assertEquals(3, this.list.size());
        assertEquals("C", this.list.get(1));
    }

    @Test
    public void testIndexOf() {
        this.list.add("A");
        this.list.add("B");
        this.list.add("C", 1);
        assertEquals(3, this.list.size());
        assertEquals(1, this.list.indexOf("C"));
        assertEquals(0, this.list.indexOf("A"));
    }

    @Test
    public void testLastIndexOf() {
        this.list.add("A");
        this.list.add("B");
        this.list.add("C");
        this.list.add("B");
        this.list.add("A");
        assertEquals(0, this.list.indexOf("A"));
        assertEquals(4, this.list.lastIndexOf("A"));
        assertEquals(1, this.list.indexOf("B"));
        assertEquals(3, this.list.lastIndexOf("B"));
    }

    @Test
    public void testContains() {
        this.list.add("A");
        this.list.add("B");
        this.list.add("C", 1);
        assertEquals(3, this.list.size());
        assertTrue(this.list.contains("C"));
        assertFalse(this.list.contains("D"));
    }

    @Test
    public void testAddAndRemoveValues() {
        this.list.add("A");
        this.list.add("B");
        this.list.add("C");
        assertEquals(3, this.list.size());
        this.list.remove(1);
        assertEquals(2, this.list.size());
        assertEquals("A", this.list.get(0));
        assertEquals("C", this.list.get(1));
    }

    @Test
    public void testStringOutput() {
        this.list.add("A");
        this.list.add("B");
        this.list.add("C");

        String expected = "[A, B, C]";
        String actual = this.list.toString();

        assertTrue(expected.equals(actual));
    }
}
