package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.MapTest;

import java.util.Map;

public class BinarySearchTreeTest extends MapTest {
    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new BinarySearchTree<>();
    }

    /*
        public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<K, V>(20);
    }
     */
}
