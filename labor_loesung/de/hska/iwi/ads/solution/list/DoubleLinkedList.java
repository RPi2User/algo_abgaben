package de.hska.iwi.ads.solution.list;

import com.sun.jdi.Value;
import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

import java.util.List;

public class DoubleLinkedList<K extends Comparable<K>,V> extends AbstractDoubleLinkedList<K, V> {

    public V get(Object o){
        while (this.head != null && this.head.entry.getKey() != (K) o){
            this.head = this.head.next;
        }

        try {
            return this.head.entry.getValue();
        }
        catch (Exception e) {
            return null;
        }
    }

    public V put(K key, V value){
        ListElement _tmp = new ListElement(
            new SimpleEntry<K,V>(key, value),
            this.head,
            null
        );

        if (this.head == null) {
            this.head = _tmp;
            return null;
        }

        V _out = this.head.entry.getValue();

        // Sequenzielle Suche nach KEY bis Listenende
        // Danach wird this.head.next = _tmp gemacht
        while (this.head != null){
            if (this.head.entry.getKey() == key) {
                this.head.entry.setValue(value);
            }
            this.head = this.head.next;
        }
    // E: "Cannot assign field "next" because "this.head" is null"
        this.head.next = _tmp;
        this.head = this.head.next; // switch to newest element

        return _out;
    }
}
