package com.luxoft.datastructures.queue;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayQueueTest extends TestCase {

    private ArrayQueue queue;

    @BeforeEach
    protected void setUp() throws Exception {
        this.queue = new ArrayQueue(2);
    }

    @Test
    public void testEmptyQueue() {
        assertTrue(this.queue.isEmpty());
        assertEquals(0, this.queue.size());
    }

    @Test
    public void testPeekValue() {
        this.queue.enqueue("A");
        this.queue.enqueue("B");
        assertEquals("A", this.queue.peek());
    }

    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        this.queue.enqueue("A");
        this.queue.enqueue("B");

        assertEquals(2, this.queue.size());
        assertEquals("A", this.queue.dequeue());
        assertEquals("B", this.queue.dequeue());
        assertEquals(0, this.queue.size());
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        this.queue.enqueue("A");
        this.queue.enqueue("B");
        this.queue.enqueue("C");

        assertEquals(3, this.queue.size());
        assertEquals("A", this.queue.dequeue());
        assertEquals("B", this.queue.dequeue());
        assertEquals("C", this.queue.dequeue());

        assertEquals(0, this.queue.size());
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testClearQueue() {
        assertTrue(this.queue.isEmpty());

        this.queue.enqueue("A");
        this.queue.enqueue("B");
        this.queue.enqueue("C");
        this.queue.enqueue("D");

        assertTrue(!this.queue.isEmpty());

        this.queue.clear();

        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testStringOutput() {
        this.queue.enqueue("A");
        this.queue.enqueue("B");
        this.queue.enqueue("C");

        String expected = "[A, B, C]";
        String actual = this.queue.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testDequeueEmptyQueue() {
        assertTrue(this.queue.isEmpty());
        Assertions.assertThrows(IllegalStateException.class, () -> this.queue.dequeue());
    }

    @Test
    public void testContainsValue() {
        this.queue.enqueue("A");
        this.queue.enqueue("B");
        this.queue.enqueue("C");

        assertTrue(this.queue.contains("B"));
        assertFalse(this.queue.contains("D"));

        String a = (String)this.queue.dequeue();
        assertTrue("A".equals(a));

        assertTrue(this.queue.contains("B"));
    }

}
