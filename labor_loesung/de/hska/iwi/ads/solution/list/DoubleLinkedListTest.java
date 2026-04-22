package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.MapTest;

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
}
