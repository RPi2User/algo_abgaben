package de.hska.iwi.ads.solution.hastable;

class Hashtable<K extends Comparable<K>,V> extends de.hska.iwi.ads.dictionary.AbstractHashMap<K, V> {

    public Hashtable(int capacity) {
        super(capacity);
    }
}