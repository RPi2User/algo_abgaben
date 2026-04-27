package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;
import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest extends MapTest {
    /**
     * Creates and returns an implementation of the Dictionary interface.
     * Override this method in the super class
     * with, for instance, a BinarySearchTree implementation
     * <pre>
     * @override
     * public &lt;K extends Comparable&lt;K>, V> Dictionary&lt;K, V> createSearch() {
     * return new BinarySearchTree&lt;K, V>();
     * }
     * </pre>
     */
    @Override
    public <K extends Comparable<K>, V> DoubleLinkedList createMap() {
        return new DoubleLinkedList();
    }

    @Test
    void sanity01(){     // this tests the core structure of this data type
        DoubleLinkedList list = this.createMap();
        assertEquals(list.getHead(), null);
        assertEquals(list.getTail(), null);

        list.put(1, "first");

        // testing if list.head & list.tail is leading and terminating correctly
        assertEquals(list.getTail().previous, null);
        assertEquals(list.getHead().next, null);

        assertEquals(list.size(), 1);

        assertEquals(list.getHead().entry.getKey(), 1);
        assertEquals(list.getTail().entry.getKey(), 1);

        assertEquals(list.getHead().entry.getValue(), "first");
        assertEquals(list.getTail().entry.getValue(), "first");

    }

    @Test
    void sanity02_override(){ // this checks .put() override
        DoubleLinkedList list = this.createMap();
        assertEquals(list.getHead(), null);
        assertEquals(list.getTail(), null);

        assertEquals(list.put(1, "first"), null);
        assertEquals(list.put(1, "one"), "first");

        assertEquals(list.getTail().previous, null);
        assertEquals(list.getHead().next, null);
        assertEquals(list.getTail().next, list.getHead().previous);

    }

    @Test
    void sanity03_append(){ // this checks .put() with a non-null list
        DoubleLinkedList list = this.createMap();
        assertEquals(list.getHead(), null);
        assertEquals(list.getTail(), null);

        assertEquals(list.put(1, "first"), null);   // e.g. 0x100
        assertEquals(list.put(2, "second"), null);  // 0x200

        assertEquals(list.getTail().next, null);
        assertEquals(list.getHead().previous, null);
        assertNotEquals(list.getTail().previous, list.getHead().next); // 0x100 != 0x200

        assertEquals(list.getHead().entry.getValue(), "first");
        assertEquals(list.getTail().entry.getValue(), "second");
    }

    @Test
    void sanity04_get(){
        DoubleLinkedList list = this.createMap();

        assertEquals(list.put(1, "first"), null);   // e.g. 0x100
        assertEquals(list.put(2, "second"), null);  // 0x200

        assertEquals(list.get(1), "first");
        assertNotEquals(list.get(2), "first");

        assertEquals(list.get(156), null);
    }
}
