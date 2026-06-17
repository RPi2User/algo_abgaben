package de.hska.iwi.ads.solution.hastable;

import de.hska.iwi.ads.dictionary.AbstractDictionary;

import java.util.Iterator;

class Hashtable<K extends Comparable<K>,V> extends de.hska.iwi.ads.dictionary.AbstractHashMap<K, V> {

    public Hashtable(int capacity) {
        super(capacity);
    }

    public V get(Object o){
        if (o == null)
            throw new NullPointerException();

        K key = (K)o;   // wir müssen casten, weils in der Aufgabenstellung steht

        // h'(k) ist ja n % mod len(ht)
        // blöd wenn halt n keine zahl ist. wir nehmen ne Java Klasse für den Müll
        // zuätzlich kann ja auch der scheiß negativ sein, also nehmen wir anstatt ner UUID einfach noch den Absolutwert
        int start = Math.abs(key.hashCode()) % hashtable.length;

        // wir iterieren über diesen komischen hashcode
        // h(k,i) = ( (magic-trash mod len) + i²) mod len
        // wenn in der Kette ein element null ist gibts es schlichtweg nicht
        // wenn in der Kette ein element !null ist haben wir unseren key gefunden
        for (int i = 0; i < hashtable.length; i++) {
            int index = (start + i * i) % hashtable.length;

            if (hashtable[index] == null) {
                return null;
            }

            if (hashtable[index].getKey().compareTo(key) == 0) {
                return hashtable[index].getValue();
            }
        }

        throw new AbstractDictionary.DictionaryFullException();
    }

    public V put(K key, V value){
        // der gleiche iterator-hashcode-müll nochmal
        int start = Math.abs(key.hashCode()) % hashtable.length;
        for (int i = 0; i < hashtable.length; i++) {
            int index = (start + i * i) % hashtable.length;
            if (hashtable[index] == null) { // wenn element noch nicht drin ist
                hashtable[index] = new SimpleEntry<>(key, value);
                size++;
                return null;
            }
            if(hashtable[index].getKey().compareTo(key) == 0) {
                hashtable[index].setValue(value); // wenn wir überschreiben sollen
                return hashtable[index].getValue();
            }
        }
        return null;
    }
}